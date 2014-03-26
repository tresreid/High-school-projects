data Poly = Poly [Double]

eval :: Poly -> Double -> Double
eval (Poly []) _ = 0
eval (Poly (x:xs)) v = rec where
    rec = x+v* (eval (Poly xs) v)