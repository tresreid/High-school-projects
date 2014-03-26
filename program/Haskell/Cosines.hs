-- lawOfCosines.hs

square x = x*x
radToDeg x = (x*pi)/180

lawOfCosines x y z = sqrt (square x +square y - 2*x*y* cos (radToDeg z))
