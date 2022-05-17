package game;

import java.util.Arrays;
import java.util.Scanner;
import pieces.*;

public class Board {
	
	
	public Boolean activePlayerIsWhite;
	public int[] whiteKingLoc;
	public int[] blackKingLoc;
	/*
	 * The Board is represented as shown below from white's perspective
	 * Note that board[0][0] would be the top left, board[0][1] would be one to the right of that
	 * i.e. it is different from chess notation, where a1 would be the bottom left.
	 * 
	 * additionally, the array is indexed as a matrix, so to find a rank and file it would be board[rank][file], rank will often come before the file
	 *  :0 1 2 3 4 5 6 7
	 * 0:R K B Q K B K R
	 * 1:P P P P P P P P
	 * 2:* * * * * * * *
	 * 3:* * * * * * * *
	 * 4:* * * * * * * *
	 * 5:* * * * * * * *
	 * 6:P P P P P P P P
	 * 7:R K B Q K B K R
	 */
	
	//Checks: if a piece of opposite color to a certain king has that king as a legal move, it is in check. 
	//
	public void setKingLocation() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.getBoard()[i][j] == null)
					continue;
				if (this.getBoard()[i][j].getType() == "King") {
					if (this.getBoard()[i][j].getIsWhite() == true)
						this.whiteKingLoc = new int[] {i, j};
					if (this.getBoard()[i][j].getIsWhite() != true)
						this.blackKingLoc = new int[] {i, j};
				}
			}
		}
		
	}
	
	public Boolean kingInCheck(Boolean kingisWhite) {//checks if the king of that color is in check.
		this.setKingLocation();
		int[] kingloc = kingisWhite ? whiteKingLoc : blackKingLoc;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {//for each square
				if (board[i][j] != null && board[i][j].getIsWhite() != kingisWhite) {//if there is a piece of opposite color to the king we are finding out if it is in check
					for (int[] x:board[i][j].legalMoves) {
						if (Arrays.equals(x, kingloc))
							return true;
						
					}
				}
				
			}
			
		}
		return false;
	}
	
	public Piece[][] board = new Piece[8][8];
	
	public Board(Board board) { //This constructor duplicates a board.
		this.activePlayerIsWhite = board.activePlayerIsWhite;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.getBoard()[i][j] == null)
						continue;
				switch(board.getBoard()[i][j].getType()) {
				case "Pawn":
					this.getBoard()[i][j] = new Pawn(board.getBoard()[i][j].getIsWhite(), board.getBoard()[i][j].rank, board.getBoard()[i][j].file, this);
					continue;
				case "Rook":
					this.getBoard()[i][j] = new Rook(board.getBoard()[i][j].getIsWhite(), board.getBoard()[i][j].rank, board.getBoard()[i][j].file, this);
					continue;
				case "Knight":
					this.getBoard()[i][j] = new Knight(board.getBoard()[i][j].getIsWhite(), board.getBoard()[i][j].rank, board.getBoard()[i][j].file, this);
					continue;
				case "Bishop":
					this.getBoard()[i][j] = new Bishop(board.getBoard()[i][j].getIsWhite(), board.getBoard()[i][j].rank, board.getBoard()[i][j].file, this);
					continue;
				case "King":
					this.getBoard()[i][j] = new King(board.getBoard()[i][j].getIsWhite(), board.getBoard()[i][j].rank, board.getBoard()[i][j].file, this);
					continue;
				case "Queen":
					this.getBoard()[i][j] = new Queen(board.getBoard()[i][j].getIsWhite(), board.getBoard()[i][j].rank, board.getBoard()[i][j].file, this);
					continue;
				
				}
			}
			
		}
	}
	public Piece[][] getBoard() {
		return board;	
	}
	
	public Board() {
		int[] whiteKingLoc = new int[] {7,4};
		int[] blackKingLoc = new int[] {0,4};
		activePlayerIsWhite = true;
		//Creating the board with all the pieces
		
		//for Black
		board[0][0] = new Rook(false, 0, 0, this); //top left
		board[0][1] = new Knight(false, 0, 1, this);
		board[0][2] = new Bishop(false, 0, 2, this);
		board[0][3] = new Queen(false, 0, 3, this);
		board[0][4] = new King(false, 0, 4, this);
		board[0][5] = new Bishop(false, 0, 5, this);
		board[0][6] = new Knight(false, 0, 6, this);
		board[0][7] = new Rook(false, 0, 7, this);
		board[1][0] = new Pawn(false, 1,0, this);
		board[1][1] = new Pawn(false, 1, 1, this);
		board[1][2] = new Pawn(false, 1, 2, this);
		board[1][3] = new Pawn(false, 1, 3, this);
		board[1][4] = new Pawn(false, 1, 4, this);
		board[1][5] = new Pawn(false, 1, 5, this);
		board[1][6] = new Pawn(false, 1, 6, this);
		board[1][7] = new Pawn(false, 1, 7, this);
		
		//for White
		board[7][0] = new Rook(true, 7, 0, this); //bottom left
		board[7][1] = new Knight(true, 7, 1, this);
		board[7][2] = new Bishop(true, 7, 2, this);
		board[7][3] = new Queen(true, 7, 3, this);
		board[7][4] = new King(true, 7, 4, this);
		board[7][5] = new Bishop(true, 7, 5, this);
		board[7][6] = new Knight(true, 7, 6, this);
		board[7][7] = new Rook(true, 7, 7, this);
		board[6][0] = new Pawn(true, 6, 0, this);
		board[6][1] = new Pawn(true, 6, 1, this);
		board[6][2] = new Pawn(true, 6, 2, this);
		board[6][3] = new Pawn(true, 6, 3, this);
		board[6][4] = new Pawn(true, 6, 4, this);
		board[6][5] = new Pawn(true, 6, 5, this);
		board[6][6] = new Pawn(true, 6, 6, this);
		board[6][7] = new Pawn(true, 6, 7, this);
		//
		//board[5][2] = new Pawn(false, 5, 2);//this is for testing
		
	}
	
	
	public Boolean addMove(int[] movedPieceLoc, int[] moveDestination) {
		if (board[movedPieceLoc[0]][movedPieceLoc[1]] != null && board[movedPieceLoc[0]][movedPieceLoc[1]].isInLegalMoves(moveDestination)) {
			if (this.getBoard()[movedPieceLoc[0]][movedPieceLoc[1]].getIsWhite() != this.activePlayerIsWhite || movePutsKingInCheck(movedPieceLoc, moveDestination))
				return false;
			Boolean moveDestinationIsNull = (this.getBoard()[moveDestination[0]][moveDestination[1]] == null);
			board[moveDestination[0]][moveDestination[1]] = board[movedPieceLoc[0]][movedPieceLoc[1]];
			board[movedPieceLoc[0]][movedPieceLoc[1]] = null;
			board[moveDestination[0]][moveDestination[1]].setFile(moveDestination[1]);
			board[moveDestination[0]][moveDestination[1]].setRank(moveDestination[0]);
			
			if (board[moveDestination[0]][moveDestination[1]].getType() == "Pawn") {//if a pawn is moved, we need to do some things
				((Pawn) board[moveDestination[0]][moveDestination[1]]).setHasMoved(true);
				if (Math.abs(moveDestination[0] - movedPieceLoc[0]) == 2) {//if pawn double moved
					((Pawn) board[moveDestination[0]][moveDestination[1]]).setJustDoubleMoved(true);
				}
				else {
					((Pawn) board[moveDestination[0]][moveDestination[1]]).setJustDoubleMoved(false);
				}
				if (moveDestination[0] == 7 || moveDestination[0] == 0) {//makes it promote to a queen
					this.getBoard()[moveDestination[0]][moveDestination[1]] = null;
					this.getBoard()[moveDestination[0]][moveDestination[1]] = new Queen(activePlayerIsWhite, moveDestination[0], moveDestination[1], this);
				}
				
				if (moveDestinationIsNull && movedPieceLoc[1] - moveDestination[1] != 0) {//if en passant was played
					if (this.activePlayerIsWhite)
						this.getBoard()[movedPieceLoc[0]][movedPieceLoc[1] - (movedPieceLoc[1] - moveDestination[1])] = null;
				}
		
				//if ()
				
			}
			//this is to clear just double moved so that we can't capture en passant longer than we should be able to. This is not a good way to implement it.
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (this.getBoard()[i][j] != null && this.getBoard()[i][j].getType() == "Pawn" && this.getBoard()[i][j].getIsWhite() != this.activePlayerIsWhite) {
						((Pawn)this.getBoard()[i][j]).setJustDoubleMoved(false);
					}
						
				}
			}
				
				
			
			activePlayerIsWhite = !activePlayerIsWhite;
			return true;
		}
		return false;
	}
	
	public Boolean movePutsKingInCheck(int[] movedPieceLoc, int[] moveDestination) {//this copies the board, adds a move, and finds if it puts their own king in check.
		Board copy = new Board(this);
		copy.getBoard()[moveDestination[0]][moveDestination[1]] = board[movedPieceLoc[0]][movedPieceLoc[1]];
		copy.getBoard()[movedPieceLoc[0]][movedPieceLoc[1]] = null;
		copy.getBoard()[moveDestination[0]][moveDestination[1]].setFile(moveDestination[1]);
		copy.getBoard()[moveDestination[0]][moveDestination[1]].setRank(moveDestination[0]);
		copy.setAllMoves();
		if (copy.kingInCheck(activePlayerIsWhite))//if the move puts the king of that player in check
			return true;
		return false;
	}
	
	public void displayBoard() {
		System.out.println("   0 1 2 3 4 5 6 7");
		for (int i = 0; i < 8; i++) {
			StringBuilder bldr = new StringBuilder();
			bldr.append(i + " ");
			for (int j = 0; j < 8; j++) {
				bldr.append(" ");
				
				if (board[i][j] == null) {
					bldr.append(" ");
					continue;
				}
				if (board[i][j].getIsWhite()) {
					switch(board[i][j].getType()){
					case "Pawn" :
						bldr.append("P");
						continue;
					case "Knight" :
						bldr.append("N");
						continue;
					case "Bishop" :
						bldr.append("B");
						continue;
					case "Rook" :
						bldr.append("R");
						continue;
					case "Queen" :
						bldr.append("Q");
						continue;
					case "King" :
						bldr.append("K");
						continue;
					}
				}
				if (!board[i][j].getIsWhite()) {
					switch(board[i][j].getType()){
					case "Pawn" :
						bldr.append("p");
						continue;
					case "Knight" :
						bldr.append("n");
						continue;
					case "Bishop" :
						bldr.append("b");
						continue;
					case "Rook" :
						bldr.append("r");
						continue;
					case "Queen" :
						bldr.append("q");
						continue;
					case "King" :								
						bldr.append("k");
						continue;
						
					}
				}
				
					
				
				
				
			}
			System.out.println(bldr.toString());
			//System.out.println("\n");
			
		}
		
	}
	
	int[][] getMove(Scanner input) {
		
		System.out.println("enter the RANK of the piece you want to move");
		int rankpiece = input.nextInt();
		System.out.println("enter the FILE of the piece you want to move");
		int filepiece = input.nextInt();
		System.out.println("enter the RANK of the square you want ot move to");
		int rankmove = input.nextInt();
		System.out.println("enter the FILE of the square you want to move to");
		int filemove = input.nextInt();
		int[] pieceloc = new int[] {rankpiece, filepiece};
		int[] moveloc = new int[] {rankmove, filemove};
		
		return new int[][] {pieceloc, moveloc};
		
	}
	
	void setAllMoves() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null)
					board[i][j].setLegalMoves();
				
			}
			
		}
		
	}
	
	
	

}
