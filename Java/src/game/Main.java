package game;
import java.util.Arrays;
import java.util.Scanner;

import pieces.*;

public class Main {
	public static void main(String args[]) {
		//Scanner input = new Scanner(System.in);
		Board board = new Board();
		
		
		//int i = 0;
		GUI gui = new GUI(board);
		gui.updateDisplay();
		//board.setAllMoves();

		
		//testing stuff
		//board.displayBoard();
		gui.updateDisplay();
		//int[] cord = {4,1}; //cord of the piece we want to get legal moves of.
		//((Pawn) Board.board[cord[0]][cord[1]]).setLegalMoves();
		//System.out.println(((Rook) Board.board[0][0]).rank);
		//for (int i = 0; i < board.board[cord[0]][cord[1]].legalMoves.size(); i++) {
		//	System.out.println(Arrays.toString(board.board[cord[0]][cord[1]].legalMoves.get(i)));
		
		
		//}
		
	}
}
