
import Prelude hiding (sum, product,map)

--product [] = 1
--product (x:xs) = x * product xs

--product_sq = product . map (^2)

--foldr combiner base [] = base
--foldr combiner base (x:xs) = combiner x (foldr combiner base xs)

product = foldr (*) 1
square x = x^2

map :: (a -> b) -> [a]-> [b]
--map _ [] = []
map f xs = foldr (\x acc -> f x : acc) [] xs -- learned at learnyouahaskell, higher order functions.

