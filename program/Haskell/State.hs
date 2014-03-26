{- A pedagogical implementation of the standard State monad -}

module State where

data State s a = State {
    runState :: s -> (a,s)
}

instance Functor (State s) where
    fmap f ma = State $ (\(a,t) -> (f a,t)) . runState ma

instance Monad (State s) where
    ma >>= g = State $ (\(a,s) -> runState (g a) s) . runState ma
    return a = State $ (,) a

{- constructor -}

state :: (s -> (a,s)) -> State s a
state = State

{- primitive state manipulation functions -}

get :: State s s
get = State $ \s -> (s,s)

put :: s -> State s ()
put t = State $ const ((),t)

modify :: (s -> s) -> State s ()
modify f = State $ (,) () . f
