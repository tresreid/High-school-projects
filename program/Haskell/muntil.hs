import Data.Char
import System.Environment
import System.Exit
import System.IO

hMaybeGetChar :: Handle -> IO (Maybe Char)
hMaybeGetChar input = do
    c <- getChar
    case c of
        hIsEOF -> Nothing
        otherwise -> Just c
    
--whileJust :: Monad m => m (Maybe a) -> (a -> m b) -> m()
--whileJust (input) f
--    | Just c =  f c
--    | otherwise = m ()