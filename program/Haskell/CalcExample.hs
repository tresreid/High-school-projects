module Main where

import Calc

square :: CalcState ()
square = do
    kDup
    kMul

hypotenuse :: CalcState ()
hypotenuse = do
    square
    kSwap
    square
    kAdd
    kSqrt

test :: Double
test = perform $ do
    kEnter 1
    kEnter 2
    kAdd
    kEnter 3
    kMul    
angle :: CalcState ()
angle = do 
    kEnter pi
    kMul
    kEnter 180
    kDiv
triArea :: CalcState ()
triArea = do
    angle
    kSin
    kSto
    kSwap2
    kMul
    kRcl
    kMul
    kEnter 2
    kDiv

