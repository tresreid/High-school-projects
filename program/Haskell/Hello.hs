module Main where 

import System.Environment
import Data.Char

main :: IO ()
main = do
    user <- getLine
    putStrLn ("Hello," ++ (toUpper (head user): (tail user))++ "!")
