from tkinter import *

#Fields
board=[[0,0,0],#represents the board
       [0,0,0],
       [0,0,0]]
side = 'X' #represents starting player
game_over = False

#Functions
def add_move(row,col, button): #performs board actions changes when a move is made
    global game_over
    global side #allos us to change the side field from this function
    if game_over:
        return
    board[row][col] = side #adds it to the board
    check_for_win(side, board)
    button["state"] = "disabled" #disables button so it can't be pressed again
    button["text"] = side #applies side to the button
    if check_for_win(side, board):
        top= Toplevel(root)
        top.geometry("100x50")
        top.title("Child Window")
        Label(top, text= side+"'s won!", font=('Mistral 18 bold')).place(x=0,y=0)
        
    if side == 'X':
        side = 'O'
    else: 
        side = 'X'    

def check_for_win(side, board):#returns if the board has been won for the side
    global game_over
    #iterate for rows
    for i in range(0,len(board)):#for row i
        for j in range(0,len(board)):#for column j corresponding with row i
            if board[i][j]!=side: #if any of these aren't the side, then they haven't won on that row, so we break to the next row
                break
            if j==len(board)-1:
                game_over = True
                return True #if we haven't broke and we are on the final iteration, then side has won.
    #iterate for columns
    for i in range(0,len(board)):#for column i
        for j in range(0,len(board)):#for row j corresponding with column i
            if board[j][i]!=side: #if any of these aren't the side, then they haven't won on that row, so we break to the next row
                break
            if j==len(board)-1:
                game_over = True
                return True #if we haven't broke, then side has won.
    #iterate for diagonal hit index 0, 4, 8 and 2, 4, 6
    
    for i in range(0, len(board)):
        if board[i][i] != side:
            break
        if i==len(board)-1:
            game_over = True
            return True
    for i in range(0, len(board)):
        if board[i][len(board)-1-i] != side:
            break
        if i==len(board)-1:
            game_over = True
            return True
    return False


#GUI Code
root = Tk() #creates base widget
root.geometry("700x700")

#adds buttons
button1=Button(root,padx=50,pady=50, command = lambda: add_move(0,0,button1), font=("Arial", 25))
button1.grid(row=1,column=1)

button2=Button(root,padx=50,pady=50, command = lambda: add_move(0,1,button2), font=("Arial", 25))
button2.grid(row=1,column=2)

button3=Button(root,padx=50,pady=50, command = lambda: add_move(0,2,button3), font=("Arial", 25))
button3.grid(row=1,column=3)

button4=Button(root,padx=50,pady=50, command = lambda: add_move(1,0,button4), font=("Arial", 25))
button4.grid(row=2,column=1)

button5=Button(root,padx=50,pady=50, command = lambda: add_move(1,1,button5), font=("Arial", 25))
button5.grid(row=2,column=2)

button6=Button(root,padx=50,pady=50, command = lambda: add_move(1,2,button6), font=("Arial", 25))
button6.grid(row=2,column=3)

button7=Button(root,padx=50,pady=50, command = lambda: add_move(2,0,button7), font=("Arial", 25))
button7.grid(row=3,column=1)

button8=Button(root,padx=50,pady=50, command = lambda: add_move(2,1,button8), font=("Arial", 25))
button8.grid(row=3,column=2)

button9=Button(root,padx=50,pady=50, command = lambda: add_move(2,2,button9), font=("Arial", 25))
button9.grid(row=3,column=3)

root.mainloop()#Creates the GUI
