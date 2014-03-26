
data Complex = Complex Double Double 
    deriving (Show,Eq) 

instance Num Complex where 
    Complex a b + Complex c d = Complex (a+c) (b+d)
    Complex a b * Complex c d = Complex (a*c-b*d) (a*d+b*c)
    abs (Complex a b) = Complex (sqrt (a^2 + b^2)) 0
    signum (Complex a b)
        | (a==0) && (b==0) = Complex 0 0
        | (a/=0) || (b/=0) = Complex (a/ sqrt (a^2 + b^2)) (b/ sqrt (a^2 + b^2))
    fromInteger n = Complex (fromInteger n) 0 


    
    