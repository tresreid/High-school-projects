{- The basic functionality of a hypothetical RPN calculator with infinite stack -}

module Calc (CalcState,kEnter,kAdd,kSub,kMul,kDiv,kSqrt,kSto, kRcl,kSwap,kDup,perform, kSin, kSwap2) where

import State

data InternalState = InternalState {
    stack :: [Double],
    memory :: Double
}

type CalcState = State InternalState

{- private functions -}

pop :: CalcState Double
pop = state $ \st -> case stack st of
	[] -> (0.0,st)
	x:xs -> (x,st { stack = xs })

push :: Double -> CalcState ()
push d = modify  $ \st -> st { stack = d : stack st }

store :: Double -> CalcState ()
store d = modify $ \st -> st { stack = reverse (d: (reverse (stack st)))}

recall :: CalcState Double
recall = state $ \st -> case stack st of 
        [] -> (0.0,st)
        xs -> ((last xs), (st {stack = init xs}))
unop :: (Double -> Double) -> CalcState ()
unop op = do
    x <- pop
    push $ op x

binop :: (Double -> Double -> Double) -> CalcState ()
binop op = do
    y <- pop
    x <- pop
    push $ op x y


{- exported calculator operations -}

kEnter :: Double -> CalcState ()
kEnter = push

kAdd, kSub, kMul, kDiv :: CalcState ()
kAdd = binop (+)
kSub = binop (-)
kMul = binop (*)
kDiv = binop (/)

kSqrt :: CalcState ()
kSqrt = unop sqrt

kSin,kCos,kTan :: CalcState ()
kSin = unop sin
kCos = unop cos
kTan = unop tan

kSto :: CalcState ()
kSto = do
    x <- pop
    store x

kRcl :: CalcState ()
kRcl = do
     x <- recall
     push x

{- exported stack operations -}

kSwap :: CalcState ()
kSwap = do
    y <- pop
    x <- pop
    push y
    push x
kSwap2 :: CalcState ()
kSwap2 = do
    z <- pop
    y <- pop
    x <- pop
    push z
    push y 
    push x

kDup :: CalcState ()
kDup = do
    x <- pop
    push x
    push x

{- execution of a calculator program -}

perform :: CalcState a -> Double
perform ma = fst $ runState (ma >> pop) startState where
    startState = InternalState [] 0.0

