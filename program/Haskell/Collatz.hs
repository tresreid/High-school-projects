collatz :: Int -> Int
collatz x 
    | even x = (x `div` 2)
    | otherwise = (3*x)+1

--cseq :: Integer -> [Integer]->[Integer]
cseq x = (takeUntil (/=1) $ iterate collatz x)

--takeUntil               :: (a -> Bool) -> [a] -> [a]
takeUntil _ []          =  []
takeUntil p (x:xs) 
            | p x       =  x : takeUntil p xs
            | otherwise =  [1]


