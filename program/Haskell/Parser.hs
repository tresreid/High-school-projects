module Parser (Parser,satisfy,char,string,many,many1,(+++)) where

import Data.Char
import Control.Monad
import Control.Monad.State
import Data.Either
import Data.Maybe
import Text.ParserCombinators.ReadP

type Parser' = StateT String []
type Parser = ReadP

parser ::(String -> [(a,String)]) -> Parser' a
parser = StateT

alpha,digit :: Parser Char
alpha = satisfy isAlpha
digit = satisfy isDigit

StateT sa <++ StateT sb = StateT $ \input -> case sa input of
  []   -> sb input
  els  -> els

data IntV = IntV Int 
    deriving (Show) 

parseInt :: Parser Int
parseInt = fmap reader (many1 $ satisfy isInt) where
    reader "" = read "0"
    reader x = read x

--option :: Parser Int -> Parser Int -> Parser Int
--option x p = p +++ x

isNeg :: Char -> Bool
isNeg c = case generalCategory c of
    DashPunctuation -> True
    _               -> False
isInt :: Char -> Bool
isInt c 
    | (isDigit c || isNeg c) = True
    | otherwise = False

skipNeg :: Parser () 
skipNeg = fmap (const ()) $ many (satisfy isNeg)

isPunctuation' :: Char -> Bool
isPunctuation' c = case generalCategory c of
        ConnectorPunctuation    -> True
        OpenPunctuation         -> True
        ClosePunctuation        -> True
        InitialQuote            -> True
        FinalQuote              -> True
        OtherPunctuation        -> True
        _                       -> False
data ComplexInt = ComplexInt Int Int
    deriving (Show)
skipPunc :: Parser ()
skipPunc = fmap (const ()) $ many (satisfy isPunctuation')

parseComplexInt :: Parser ComplexInt
parseComplexInt = do
           string "ComplexInt"
           skipSpaces
           skipPunc
           skipSpaces
           c <- parseInt
           skipSpaces
           skipPunc
           skipSpaces
           d <- option 0 parseInt
           skipSpaces
           skipPunc
           skipSpaces
           return $ ComplexInt c d
instance Read ComplexInt where
    readsPrec _ = readP_to_S parseComplexInt