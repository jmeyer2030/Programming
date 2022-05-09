#include <iostream>
#include <vector>
#include <chrono>
#include <thread>


struct Game
{
	//These are the assignments for players as found on the board
	int playerX = -1;
	int playerO = 0;

	//game status variables
	bool Drawn = 0;
	bool gameOver = 0;	
	int winner;
	int whoseTurn = playerX;
	
	//board related variables
	int boardSize;
	bool sizeIsOdd;
	std::vector<std::vector<int>> board;


	Game(int n)
	{
		createBoard(n);
	}

	bool addMove(int moveIndex) 
	{
		if (gameOver == 1 || !validMove(moveIndex))
		{
			return 0;
		}
		std::cout << "move added for " << moveIndex << std::endl;
		int* ptr = squareNumberToIndex(moveIndex);
		int moveRow = ptr[0];
		int moveCol = ptr[1];
		if (validMove(moveIndex))//if index hasn't been used
		{
			board[moveRow][moveCol] = whoseTurn;
			if (whoseTurn == playerX)
			{
				whoseTurn = playerO;
			}
			else
			{
				whoseTurn = playerX;
			}
			return 1;
		}
		return 0;
		
	
	}

	bool validMove(int moveIndex)//probably should make this method and put it in add move.
	{
		int* ptr = squareNumberToIndex(moveIndex);
		int moveRow = ptr[0];
		int moveCol = ptr[1];
		if (board[moveRow][moveCol] != playerX && board[moveRow][moveCol] != playerO) // if the position is not taken
			return 1;
		return 0;
	}

	
	void createBoard(int n) //sets board size, if its odd or even, and creates the board with values 1 to n^2
	{
		boardSize = n;
		if (n % 2 == 0)
			sizeIsOdd = 1;
		else
			sizeIsOdd = 0;
		board = std::vector<std::vector<int>>(n);

		for (int i = 0; i < n; i++)
		{
			board[i] = std::vector<int>(n);
			for (int j = 0; j < n; j++) {
				board[i][j] = (int) i * n + j + 1;
			}
		}
	}

	bool checkForDraw() {
		for (int i = 0; i < boardSize; i++)
		{
			for (int j = 0; j < boardSize; j++)
			{
				if (board[i][j] != playerX && board[i][j] != playerO)
				{
					return 0;
				}
			}
		}
		gameOver = true;
		Drawn = true;
		return 1;
	}

	int* squareNumberToIndex(int n) 
	{
		int index[2] = { (int)((n - 1) / boardSize),  n % boardSize  - 1};
		if (index[1] == -1)
		{
			index[1] = boardSize - 1;
		}
		return index;//returns address of index
	}

	bool winByRows(int side) {
		for (int i = 0; i < boardSize; i++) 
		{
			for (int j = 0; j < boardSize; j++)
			{
				if (board[i][j] != side)
				{
					break;
				}
				if (j == (boardSize - 1))
				{
					gameOver = 1;
					winner = side;
					return 1;
				}
			}
		}
		return 0;
	}

	bool winByCols(int side) {
		for (int i = 0; i < boardSize; i++)
		{
			for (int j = 0; j < boardSize; j++)
			{
				if (board[j][i] != side)
				{
					break;
				}
				if (j == (boardSize - 1))
				{
					gameOver = 1;
					winner = side;
					return 1;
				}
			}
		}
		return 0;
	}

	bool winByDiag(int side) 
	{
		for (int i = 0; i < boardSize; i++)
		{
			if (board[i][i] != side)
			{
				break;
			}
			if (i == (boardSize - 1))
			{
				gameOver = 1;
				winner = side;
				return 1;
			}
		}
		for (int i = 0; i < boardSize; i++)
		{
			if (board[boardSize - 1 - i][i] != side)
			{
				break;
			}
 			if (i == (boardSize -1))
			{				
				gameOver = 1;
				winner = side;
				return 1;

			}
		}
		return 0;
	}

	bool checkForWin(int side)
	{
		if (winByCols(side) || winByRows(side) || winByDiag(side))
		{
			gameOver = 1;
			winner = side;
			return 1;

		}
		return 0;
	}

};

struct GameManager
{
	Game* game; //this is a pointer to the game that this class is managing

	GameManager(Game* managedGame)
	{
		game = managedGame;
	}
	
	void displayBoard() {
		for (int i = 0; i < (*game).boardSize; i++)
		{
			for (int j = 0; j < (*game).boardSize; j++)
			{
				if ((*game).board[i][j] == 0)
				{
					std::cout << "O ";
				}
				else if ((*game).board[i][j] == -1) 
				{
					std::cout << "X ";
				}
				else {
					std::cout << (*game).board[i][j] << " ";
				}
			}
			std::cout << std::endl;
		}
	}

	void runGame()
	{

	}
	

};

class AI
{

};




int main() {
	int dimension = 5;
	Game gameinst = Game(dimension);
	Game* ptr = &gameinst;
	GameManager gameman = GameManager(ptr);
	//gameman.displayBoard();
	int x;
	while (gameinst.gameOver == false)
	{
		
		gameman.displayBoard();
		std::cout << "enter your move:" << std::endl;
		std::cin >> x;
		std::cout << "you chose " << x << std::endl;
		gameinst.addMove(x);
		gameinst.checkForWin(gameinst.playerO);
		gameinst.checkForWin(gameinst.playerX);
		gameinst.checkForDraw();
		//std::this_thread::sleep_for(std::chrono::seconds(1));
		system("cls");

	}
	gameman.displayBoard();
	if (gameinst.winner == 0)
	{
		std::cout << "X's won!";
	}
	if (gameinst.winner == -1)
	{
		std::cout << "O's won!";
	}
	if (gameinst.Drawn) 
	{
		std::cout << "game was drawn";
	}

}