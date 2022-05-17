package pieces;

import game.Board;



public class Pawn extends Piece{ 
	
	boolean hasMoved = false;
	boolean justDoubleMoved = false;
	Board board;
	public Pawn(Boolean isWhite, int rank, int file, Board board) {
		this.board = board;
		this.setIsWhite(isWhite);		
		this.rank = rank;
		this.file = file;
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public void setJustDoubleMoved(boolean justDoubleMoved) {
		this.justDoubleMoved = justDoubleMoved;
	}

	public boolean getJustDoubleMoved() {
		return justDoubleMoved;
	}
	
	public String getType() {
		return "Pawn";
	}
	
	public void setLegalMoves() {
		legalMoves.clear();
		
		//these are for forward moves. Only allowed if forward squares are clear, double moves are covered, and depends on clear squares and not having moved before
		//done without arrays (reducing code) to increase simplicity since repeated only once.
		
		//for white
		if ((this.rank - 1) >= 0 && //space in front of it is in bounds
			this.getIsWhite() && //is white
			board.getBoard()[this.rank - 1][this.file] == null){//space in front is empty
			legalMoves.add(new int[] {this.rank  - 1, this.file});
			if (board.getBoard()[this.rank - 2][this.file] == null && this.hasMoved == false &&
				this.rank -2 >= 0) {
				legalMoves.add(new int[] {this.rank  - 2, this.file});
			}
		}
		//for black
		if (this.rank + 1 <= 7 &&
			!this.getIsWhite() && 
			board.getBoard()[this.rank + 1][this.file] == null){
			legalMoves.add(new int[] {this.rank  + 1, this.file});
			if (this.rank + 2 <= 7 &&
				board.getBoard()[this.rank + 2][this.file] == null && this.hasMoved == false) {
				legalMoves.add(new int[] {this.rank  + 2, this.file});
			}
		}
		
		//these are for captures. Requires a opposite colored piece to be diagonal forward adjacent
		//done with arrays for s's and g's
		
		int[] plusandminus = {-1, 1};
		boolean pieceCaptureColor = true; //true means it can capture white pieces
		if (this.getIsWhite() == true)//if white, it should be able to capture black pieces
			pieceCaptureColor = false;
		int forwardorbackward = (this.getIsWhite()) ? -1 : 1; //if white, it is moving forward, if black it is moving backward
		
		for (int x : plusandminus) {
			if (this.rank + forwardorbackward <= 7 && this.rank + forwardorbackward >= 0 &&//if inbounds and
				this.file + x <= 7 && this.file + x >= 0 &&
				board.getBoard()[this.rank + forwardorbackward][this.file + x] != null && //if there is a piece there and
				pieceCaptureColor == board.getBoard()[this.rank + forwardorbackward][this.file + x].getIsWhite()) {//if that piece is of opposite color
				legalMoves.add(new int[] {this.rank + forwardorbackward, this.file + x});
			}
		}
		
		//en passant is a legal move iff: 
				//there is an opposite colored pawn in an adjacent file.
				//AND if that pawn is on rank 3 if black or 4 if white
				//AND on the previous ply, that pawn made its first move
		for (int x:plusandminus) {
			if (this.getIsWhite() && this.file + x <= 7 && this.file + x >= 0 && this.rank - 1 >= 0 && this.rank == 3 && board.getBoard()[this.rank][this.file + x] != null //if this is white and that space has a piece
			&& board.getBoard() [this.rank - 1][this.file + x] == null && 
			board.getBoard()[this.rank][this.file + x].getClass() == this.getClass() &&//if it is a pawn
			((Pawn)board.getBoard()[this.rank][this.file + x]).justDoubleMoved == true //if that pawn just double moved
			&& !board.getBoard()[this.rank][this.file + x].getIsWhite()) { //if that pawn is a different color
				legalMoves.add(new int[] {this.rank - 1, this.file + x});
			}
		}
		
		for (int x:plusandminus) {
			if (!this.getIsWhite() && this.file + x <= 7 && this.file + x >= 0 && this.rank + 1 <= 7 && this.rank == 4 && board.getBoard()[this.rank][this.file + x] != null //if this is white and that space has a piece
			&& board.getBoard() [this.rank + 1][this.file + x] == null && 
			board.getBoard()[this.rank][this.file + x].getClass() == this.getClass() &&//if it is a pawn
			((Pawn)board.getBoard()[this.rank][this.file + x]).justDoubleMoved == true //if that pawn just double moved
			&& board.getBoard()[this.rank][this.file + x].getIsWhite()) { //if that pawn is a different color
				legalMoves.add(new int[] {this.rank + 1, this.file + x});
			}
		}
		
	}
	
}
