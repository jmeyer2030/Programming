package pieces;

import game.Board;

public class Rook extends Piece{
	
	public Board board;
	
	public Rook(Boolean isWhite, int rank, int file, Board board) {
		this.board = board;
		this.setIsWhite(isWhite);		
		this.rank = rank;
		this.file = file;
	}
	
	public String getType() {
		return "Rook";
	}
	
	public void setLegalMoves() { // a legal move is at least one square away from the rook in question, and cannot open an attack on that color's king.
		legalMoves.clear();
		
		
		/*Each while loop checks the following before proceeding
		 * is the next index out of bounds?
		 * is the next index empty?
		 * is the next index a piece of the same color?
		 * 
		 * NEED TO IMPLEMENT IF IT IS PINNED TO THE KING, should probably have a function for detecting a check.
		 * If a move results in their own king being put in check, then it should not be added
		 * 
		 * 
		 * 
		 */
		
		//this is for rank
		
		int i = 1;
		
		while((this.rank + i <= 7) && //while the square we are looking at is in bounds AND
		((board.getBoard()[this.rank + i][this.file] == null) //this square is empty OR
		|| (board.getBoard()[this.rank + i][this.file].getIsWhite() != this.getIsWhite()))) { //this square has a piece that is of opposite color
			
			legalMoves.add(new int[]{this.rank + i, this.file}); //we add it as a legal move
			
			if (board.getBoard()[this.rank + i][this.file] != null //if there is a piece there
			&& board.getBoard()[this.rank + i][this.file].getIsWhite() != this.getIsWhite())//AND if that piece is a different color than this piece
				break; //we break since there a move isn't allowed if it passes through a enemy piece
			i++; //and increment i so that we will look at the next square when this loop repeats
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
