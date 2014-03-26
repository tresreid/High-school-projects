data Branch x = Leaf x | Node (Branch x) x (Branch x)
    deriving (Show)

instance Functor Branch where
    fmap f (Leaf x) = Leaf (f x)
    fmap f (Node y x z) = Node (fmap f y) (f x) (fmap f z)