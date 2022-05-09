from turtle import*
import random
from random import randint


def getNewPoint(char, point):
    global pointa, pointb, pointc;

    if (char == 'a'):
        return midpoint(pointa, point)
    if (char == 'b'):
        return midpoint(pointb, point)
    else:
        return midpoint(pointc, point)

def midpoint(loc1, loc2):
    midpoint = [(loc1[0]+loc2[0])/2,(loc1[1]+loc2[1])/2]
    return midpoint

def randomColor():
    r = randint(1,255)    # red component of color
    g = randint(1,255)    # green component
    b = randint(1,255)    # blue component
    return r,g,b

penup()
speed(0)
#begin_fill()
pointa = [0,50]
pointb = [400, 50]
pointc = [200, 1500/4]
location = [50,50]
n = 0
pencolor("Blue")
while True:
    n = n+1;
    direction = 'd'
    rand = random.uniform(0, 1);
    if (rand < 1/3):
        direction = 'a'
    elif (rand > 2/3):
        direction = 'b'
    else: 
        direction = 'c'
    location = getNewPoint(direction, location);
    goto(location[0], location[1])
    colormode(255)
    #pencolor(randomColor())
    dot(2)
    print(n)
    if n==100_000:
        break
end_fill()
done()