package pieces;

import game.Board;

public class Bishop extends Piece {
	Board board;
	public Bishop(Boolean isWhite, int rank, int file, Board board) {
		this.setIsWhite(isWhite);		
		this.rank = rank;
		this.file = file;
		this.board = board;
	}
	
	public String getType() {
		return "Bishop";
	}
	
	public void setLegalMoves() { //THIS CODE SHOULD BE REFORMATED TO BE HOW THE KNIGHT IS ATM
		legalMoves.clear();
		int i = 1;
		
		//this is for the both increasing/both decreasing diagonal
		while(((this.rank + i <= 7) && (this.file + i <= 7)) && //while the square we are looking at is in bounds AND
		((board.getBoard()[this.rank + i][this.file + i] == null) //this square is empty OR
		|| (board.getBoard()[this.rank + i][this.file + i].getIsWhite() != this.getIsWhite()))) { //this square has a piece that is of opposite color
			
			legalMoves.add(new int[]{this.rank + i, this.file + i}); //we add it as a legal move
			
			if (board.getBoard()[this.rank + i][this.file + i] != null //if there is a piece there
			&& board.getBoard()[this.rank + i][this.file + i].getIsWhite() != this.getIsWhite())//AND if that piece is a different color than this piece
				break; //we break since there a move isn't allowed if it passes through a enemy piece
			i++; //and increment i so that we will look at the next square when this loop repeats
		}
		
		
		i = 1;
		
		while(((this.rank - i >= 0) && (this.file - i >= 0)) && //while the square we are looking at is in bounds AND
		((board.getBoard()[this.rank - i][this.file - i] == null) //this square is empty OR
		|| (board.getBoard()[this.rank - i][this.file - i].getIsWhite() != this.getIsWhite()))) { //this square has a piece that is of opposite color
			
			legalMoves.add(new int[]{this.rank - i, this.file - i}); //we add it as a legal move
			
			if (board.getBoard()[this.rank - i][this.file - i] != null //if there is a piece there
			&& board.getBoard()[this.rank - i][this.file - i].getIsWhite() != this.getIsWhite())//AND if that piece is a different color than this piece
				break; //we break since there a move isn't allowed if it passes through a enemy piece
			i++; //and increment i so that we will look at the next square when this loop repeats
		}
		
		
		//this is for the one increasing, other decreasing and vice versa diagonal
		i = 1;
		while(((this.rank - i >= 0) && (this.file + i <= 7)) && //while the square we are looking at is in bounds AND
		((board.getBoard()[this.rank - i][this.file + i] == null) //this square is empty OR
		|| (board.getBoard()[this.rank - i][this.file + i].getIsWhite() != this.getIsWhite()))) { //this square has a piece that is of opposite color
			
			legalMoves.add(new int[]{this.rank - i, this.file + i}); //we add it as a legal move
			
			if (board.getBoard()[this.rank - i][this.file + i] != null //if there is a piece there
			&& board.getBoard()[this.rank - i][this.file + i].getIsWhite() != this.getIsWhite())//AND if that piece is a different color than this piece
				break; //we break since there a move isn't allowed if it passes through a enemy piece
			i++; //and increment i so that we will look at the next square when this loop repeats
		}
		
		i = 1;
		while(((this.rank + i <= 7) && (this.file - i >= 0)) && //while the square we are looking at is in bounds AND
		((board.getBoard()[this.rank + i][this.file - i] == null) //this square is empty OR
		|| (board.getBoard()[this.rank + i][this.file - i].getIsWhite() != this.getIsWhite()))) { //this square has a piece that is of opposite color
			
			legalMoves.add(new int[]{this.rank + i, this.file - i}); //we add it as a legal move
			
			if (board.getBoard()[this.rank + i][this.file - i] != null //if there is a piece there
			&& board.getBoard()[this.rank + i][this.file - i].getIsWhite() != this.getIsWhite())//AND if that piece is a different color than this piece
				break; //we break since there a move isn't allowed if it passes through a enemy piece
			i++; //and increment i so that we will look at the next square when this loop repeats
		}
		
		
	}
		
}


