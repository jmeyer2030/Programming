from turtle import*
import turtle as tur
import random
from random import paretovariate, randint
import math


def generateThetaForCircle(perCycle): #perCycle is steps per 2pi, cycles is a multiple of 2pi
    step = 2*math.pi/perCycle
    ThetaValues = [0]*(perCycle+1)#we use n+1 so that for 4, we get 0,pi/2, pi, 3/2pi, and 2pi
    for x in range(1, perCycle+1):
        ThetaValues[x] = ThetaValues[x-1] + step
    return ThetaValues

def generateThetaForDrawing(perCycle, Cycles): #perCycle is steps per 2pi, cycles is a multiple of 2pi
    step = 2*math.pi/perCycle
    ThetaValues = [0]*(Cycles*perCycle+1)#we use n+1 so that for 4, we get 0,pi/2, pi, 3/2pi, and 2pi
    for x in range(1, Cycles*perCycle+1):
        ThetaValues[x] = ThetaValues[x-1] + step
    return ThetaValues

def draw(ThetaValues):
    global r1, r2, Center1, Center2, Point, Theta1, Theta2, ratio, Point
    tur.penup()
    tur.goto(Point[0], Point[1])
    #tur.pendown()
    tur.pendown()
    for x in ThetaValues:
        C2 = [Center1[0] + math.cos(x)*(r1-r2), Center1[1] + math.sin(x)*(r1-r2)] #defines where Center of smaller circle is given theta1. x is theta1
        Point = [C2[0]+math.cos(math.pi-x*ratio)*r2, C2[1]+math.sin(math.pi-x*ratio)*r2]
        tur.goto(Point[0], Point[1])
        #delay(100)

def drawCircles(ThetaValues):
    global Center1, r1
    tur.penup()
    tur.goto(Center1[0]+r1, Center1[1])
    tur.pendown()
    for x in ThetaValues:
        tur.goto(Center1[0]+math.cos(x)*r1, Center1[0]+math.sin(x)*r1)
    tur.penup()
    tur.goto(Center2[0]+r2, Center2[1])
    tur.pendown()
    for x in ThetaValues:
        tur.goto(Center2[0]+r2*math.cos(x), Center2[1]+r2*math.sin(x))
    tur.penup()

        


#define radius, Point, and center locations
r1 = 200
r2 = 109
Center1 = [100, 100]
Center2 = [Center1[0] + r1-r2, Center1[1]]
Point = [Center2[0]-r2, Center2[1]]
Theta1 = 0 #will increment constantly
Theta2 = 0 #will be equal to Theta1*ratio i.e if r1 is 2 and r2 is 1, then at Theta1 = 2pi, Theta2 = 4pi
ratio = (2*r1*math.pi)/(2*r2*math.pi) #reduces to r1/r2
tur.speed(0)
ThetaValuesForCircle = generateThetaForCircle(100)
ThetaValuesForDrawing = generateThetaForDrawing(100,150)
#drawCircles(ThetaValuesForCircle)
draw(ThetaValuesForDrawing)
#print(ThetaValues)

tur.done()

