package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUI implements ActionListener{
	
	public int count = 0;
	JLabel label;
	JFrame frame;
	JPanel panel;
	JButton[][] buttonarray = new JButton[8][8];
	JPanel buttonPanel;
	Board board;
	int pieceRank;
	int pieceFile;
	int destinationRank;
	int destinationFile;
	Boolean waitingForDestination = false;
	
	public GUI(Board board) {
		this.board = board;
		buttonPanel = new JPanel();
		//buttonPanel.setLayout(new GridLayout(8,8));
		frame = new JFrame();
		panel = new JPanel();
		//label = new JLabel("Chess!");
		//label.setVerticalAlignment(0);
		//label.setHorizontalAlignment(0);
		//panel.add(label);
		
		//panel.add(button);
		//button.addActionListener(this);
		//JButton button1 = new JButton("Click Me 1");
		//panel.add(button1);
		//button1.addActionListener(this);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttonarray[i][j] = new JButton();
				if ((i + j)%2 == 1)
					buttonarray[i][j].setBackground(Color.BLACK);
					buttonarray[i][j].setForeground(Color.WHITE);
				if ((i + j)%2 == 0) {
					buttonarray[i][j].setBackground(Color.WHITE);
					buttonarray[i][j].setForeground(Color.BLACK);
				}
				//buttonarray[i][j];
				panel.add(buttonarray[i][j]);
				buttonarray[i][j].addActionListener(this);
			}
			
		}
		
		
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(8,8));
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!waitingForDestination && e.getSource() == buttonarray[i][j]) {
					pieceRank = i;
					pieceFile = j;
					waitingForDestination = !waitingForDestination;
				} else if (e.getSource() == buttonarray[i][j]) {
					destinationRank = i;
					destinationFile = j;
					waitingForDestination = !waitingForDestination;
					board.addMove(new int[] {pieceRank, pieceFile}, new int[] {destinationRank, destinationFile});
					this.updateDisplay();
					board.setAllMoves();
				}
				
			}
			
		}
		
		//if (e.getSource() == button) {
			
		//}
		
	}
	public void updateDisplay() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.getBoard()[i][j] == null) {
					buttonarray[i][j].setText("");
					continue;
				}
				if (board.getBoard()[i][j].getIsWhite()) {
					switch(board.getBoard()[i][j].getType()){
					case "Pawn" :
						buttonarray[i][j].setText("P");
						continue;
					case "Knight" :
						buttonarray[i][j].setText("N");
						continue;
					case "Bishop" :
						buttonarray[i][j].setText("B");
						continue;
					case "Rook" :
						buttonarray[i][j].setText("R");
						continue;
					case "Queen" :
						buttonarray[i][j].setText("Q");
						continue;
					case "King" :
						buttonarray[i][j].setText("K");
						continue;
					}
				}
				if (!board.getBoard()[i][j].getIsWhite()) {
					switch(board.getBoard()[i][j].getType()){
					case "Pawn" :
						buttonarray[i][j].setText("p");
						continue;
					case "Knight" :
						buttonarray[i][j].setText("n");
						continue;
					case "Bishop" :
						buttonarray[i][j].setText("b");
						continue;
					case "Rook" :
						buttonarray[i][j].setText("r");
						continue;
					case "Queen" :
						buttonarray[i][j].setText("q");
						continue;
					case "King" :								
						buttonarray[i][j].setText("k");
						continue;
						
					}
				}
				
					
				
				
				
			}
			
		}
	}

}
