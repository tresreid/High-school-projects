import Data.Foldable
import Data.Monoid

data Tree a = Leaf a | Node [Tree a]
     deriving (Show) 

t :: Tree Int 
t = Node [Node [Leaf 1, Leaf 2], Node [Leaf 3, Leaf 4]]

instance Functor Tree where
    fmap f (Leaf x) = Leaf (f x)
    fmap f (Node xs) = Node (map (fmap f) xs)

instance Foldable Tree where
    foldMap f (Leaf x) = f x
    foldMap f (Node (xs)) = mconcat $ map (foldMap f) xs

findList x = Data.Foldable.foldr (:) [] t