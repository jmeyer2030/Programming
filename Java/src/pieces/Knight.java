package pieces;

import game.Board;

public class Knight extends Piece{
	public Knight(Boolean isWhite, int rank, int file, Board board) {
		this.setIsWhite(isWhite);		
		this.rank = rank;
		this.file = file;
		this.board = board;
	}
	
	public String getType() {
		return "Knight";
	}
	
	public void setLegalMoves() {
		legalMoves.clear();
		
		//The idea is that rather than writing a bunch of if statements, we reduce code written by iterating through arrays that have the coordinates already described.
		int[] rankcombos = {2,2,-2,-2,1,1,-1,-1};
		int[] filecombos = {1,-1,1,-1,-2,2,-2,2};
		for (int i = 0; i < 8; i++) {
			if (((0 <= this.rank + rankcombos[i] && this.rank + rankcombos[i] <= 7) && 0 <= this.file + filecombos[i] && this.file + filecombos[i] <= 7) && //while the square we are looking at is in bounds AND
				((board.getBoard()[this.rank + rankcombos[i]][this.file + filecombos[i]] == null) //this square is empty OR
				|| (board.getBoard()[this.rank + rankcombos[i]][this.file + filecombos[i]].getIsWhite() != this.getIsWhite()))) { //this square has a piece of opposite color
				legalMoves.add(new int[] {this.rank + rankcombos[i], this.file + filecombos[i]});
			}
		}
		
	}
}
