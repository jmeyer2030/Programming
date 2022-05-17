package pieces;

import game.Board;

public class Queen extends Piece{
	public Queen(Boolean isWhite, int rank, int file, Board board) {
		this.setIsWhite(isWhite);		
		this.rank = rank;
		this.file = file;
		this.board = board;
	}
	
	public String getType() {
		return "Queen";
	}
	
	public void setLegalMoves() {
		
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
		
		i = 1;
		
		while((this.rank + i <= 7) && //while the square we are looking at is in bounds AND
		((board.getBoard()[this.rank + i][this.file] == null) //this square is empty OR
		|| (board.getBoard()[this.rank + i][this.file].getIsWhite() != this.getIsWhite()))) { //this square has a piece that is of opposite color
			
			legalMoves.add(new int[]{this.rank + i, this.file}); //we add it as a legal move
			
			if (board.getBoard()[this.rank + i][this.file] != null //if there is a piece there
			&& board.getBoard()[this.rank + i][this.file].getIsWhite() != this.getIsWhite())//AND if that piece is a different color than this piece
				break; //we break since there a move isn't allowed if it passes through a enemy piece
			i++; 
		}
		
		
		i = 1;
		
		while((this.rank - i >= 0) && 
		((board.getBoard()[this.rank - i][this.file] == null) 
		|| (board.getBoard()[this.rank - i][this.file].getIsWhite() != this.getIsWhite()))) { 
			
			legalMoves.add(new int[]{this.rank - i, this.file}); 
			
			if (board.getBoard()[this.rank - i][this.file] != null 
			&& board.getBoard()[this.rank - i][this.file].getIsWhite() != this.getIsWhite())
				break; 
			i++; 
		}
		
		//for file
		
		i = 1;
		while((this.file + i <= 7) && 
		((board.getBoard()[this.rank][this.file + i] == null) 
		|| (board.getBoard()[this.rank][this.file + i].getIsWhite() != this.getIsWhite()))) { 
			
			legalMoves.add(new int[]{this.rank, this.file + i}); 
			
			if (board.getBoard()[this.rank][this.file + i] != null 
			&& board.getBoard()[this.rank][this.file + i].getIsWhite() != this.getIsWhite())
				break; 
			i++; 
		}

		i = 1;
		while((this.file - i >= 0) && 
		((board.getBoard()[this.rank][this.file - i] == null) 
		|| (board.getBoard()[this.rank][this.file - i].getIsWhite() != this.getIsWhite()))) { 
			
			legalMoves.add(new int[]{this.rank, this.file - i}); 
			
			if (board.getBoard()[this.rank][this.file - i] != null 
			&& board.getBoard()[this.rank][this.file - i].getIsWhite() != this.getIsWhite())
				break; 
			i++; 
		}
	
		
	}
}
