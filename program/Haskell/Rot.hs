module Main where 
import Data.Char 
import System.Environment 
import System.Exit 
import System.IO
import Data.List
import Data.Maybe
import Text.Regex.Posix

rot :: String -> [(Int,Char)] -> String
rot pass input' = map rot_char' input' where 
    rot_char' :: (Int,Char) -> Char
    rot_char' x = rot_char ((fst x))(snd x)
    rot_char :: Int->Char ->Char
    rot_char y c
        | isLower c = rot_case 'a' c y 
        | isUpper c = rot_case 'A' c y
        | otherwise = c   
    rot_case :: Char-> Char-> Int->Char
    rot_case cas c y = chr ((ord cas + (ord c - ord cas + encrypt pass y) `rem` 26))
    encrypt :: [Char]-> Int-> Int
    encrypt pass y 
        |head pass == '-' = 26- (ord ( (cycle (tail pass)) !!y )-97)
        | otherwise = (ord ( (cycle pass) !! y ) -97)
rotnum :: Int->String -> String 
rotnum n = map rot_char where 
    rot_char c 
        | isLower c = rot_case 'a' c 
        | isUpper c = rot_case 'A' c 
        | otherwise = c 
    rot_case cas c = chr (ord cas + (ord c - ord cas + n) `rem` 26)

usage :: IO () 
usage = do 
    progname <- getProgName 
    hPutStrLn stderr $ "usage: " ++ progname ++ " n" 
    exitWith $ ExitFailure 255 

rot_stdin :: String -> IO () 
rot_stdin pass = do 
    input <- getContents 
    let input' = zip [0..] input
    putStrLn $ rot pass input'

rotnum_stdin :: Int -> IO () 
rotnum_stdin n = do 
    input <- getContents 
    putStrLn $ rotnum n input

main :: IO () 
main = do 
    pass <- getLine
    args <- getArgs 
    case args of 
        [] -> rot_stdin pass 
        [x] 
            | x =~ "^-?[0-9]+$" -> rotnum_stdin ((read x)::Int)
            | x =~ "^-?['A'-'z']+$" -> rot_stdin pass
            | otherwise -> usage
        _ -> usage