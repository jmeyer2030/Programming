package pieces;
import game.Board;

public class King extends Piece{
	
	public King(Boolean isWhite, int rank, int file, Board board) {
		this.setIsWhite(isWhite);		
		this.rank = rank;
		this.file = file;
		this.board = board;
		

	}
	
	public String getType() {
		return "King";
	}
	
	public void setLegalMoves() {
		legalMoves.clear();
		
		int[] possibleKingRankMoves = {1, 1, 1, 0, 0, -1, -1, -1};
		int[] possibleKingFileMoves = {-1, 0, 1, 1, -1, -1, 0, 1};
		
		for (int i = 0; i < 8; i++) {
			if (this.rank + possibleKingRankMoves[i] <= 7 && this.rank + possibleKingRankMoves[i] >= 0 &&//is it in bounds on rank
			this.file + possibleKingRankMoves[i] <= 7 && this.file + possibleKingRankMoves[i] >= 0 && //is it in bounds on file
			(board.getBoard()[this.rank + possibleKingRankMoves[i]][this.file + possibleKingFileMoves[i]] == null || //it is either empty or a piece of the opposite color.
			board.getBoard()[this.rank + possibleKingRankMoves[i]][this.file + possibleKingFileMoves[i]].getIsWhite() != this.getIsWhite())) {
				legalMoves.add(new int[] {this.rank + possibleKingRankMoves[i], this.file + possibleKingFileMoves[i]});
			}
			
		}
	}
}
