from turtle import*
import turtle as tur
import random
from random import paretovariate, randint
import math

#lets d

list = ['X']
angle = 0;

def getNextList(list):
    nextlist = []
    for x in list:
        if x == 'X':
            nextlist.append('Y')
            nextlist.append('X')
            nextlist.append('Y')
        if x == 'x':
            nextlist.append('y')
            nextlist.append('X')
            nextlist.append('Y')
        if x == 'Y':
            nextlist.append('X')
            nextlist.append('y')
            nextlist.append('x')
        if x == 'y':
            nextlist.append('x')
            nextlist.append('y')
            nextlist.append('x')
    return nextlist

def generateDrawing(list):
    global angle
    for x in list:
        if x == 'X' or x == 'Y':
            tur.right(60)
            tur.forward(3)
        if x == 'x' or x == 'y':
            tur.left(60)
            tur.forward(3)

tur.penup()
tur.speed(0)
tur.goto(-500,500)
tur.pendown()
list = getNextList(list)
list = getNextList(list)
list = getNextList(list)
list = getNextList(list)
list = getNextList(list)
list = getNextList(list)
list = getNextList(list)
list = getNextList(list)
#list = getNextList(list)
generateDrawing(list)



tur.done()

