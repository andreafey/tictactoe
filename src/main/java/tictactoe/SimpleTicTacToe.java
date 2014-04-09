package tictactoe;

import java.util.Scanner;

public class SimpleTicTacToe {
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    SimpleBoard board = new SimpleBoard();
    String turn = "";
    System.out.println("Hello, TicTacToe.\n\nSelect rows and columns from 0-9.");
    while (!board.gameOver()) {
		turn = "x".equals(turn) ? "o" : "x";
		System.out.println(board+"\n\n"+turn+"'s turn\nrow: ");
		int row = reader.nextInt();
		System.out.println("col: ");
		int col = reader.nextInt();
		board.move(turn, row, col);
    }
    reader.close();
    if (board.isWinner(turn))
    	System.out.println(board+"\n"+turn+" wins");
    else 
    	System.out.println(board+"\nIt's a draw.");
  }
  
}

