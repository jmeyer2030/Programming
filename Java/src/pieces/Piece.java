package pieces;

import java.util.Arrays;
import java.util.LinkedList;

import game.Board;

public abstract class Piece {
	
	Board board;
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public LinkedList<int[]> getLegalMoves() {
		return legalMoves;
	}
	public void setLegalMoves(LinkedList<int[]> legalMoves) {
		this.legalMoves = legalMoves;
	}
	public int getFile() {
		return file;
	}
	public int getRank() {
		return rank;
	}

	private Boolean isWhite;
	public int file;
	public int rank;
	public LinkedList<int[]> legalMoves = new LinkedList<int[]>();
	//abstract Class<?> getClass();
	public Boolean getIsWhite() {
		return isWhite;
	}
	public void setIsWhite(Boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	
	public abstract String getType();
	public abstract void setLegalMoves();
	
	public Boolean isInLegalMoves(int[] candidate) { //.conatains doesn't work for arrays, so we use Arrays.equals
		for (int[] x:legalMoves) {
			if (Arrays.equals(x, candidate))
				return true;
		}
		return false;
	}
	
	public void setFile(int file) {
		this.file = file;
		
	}
	
	public void setRank(int rank) {
		this.rank = rank;
		
	}

	
}
