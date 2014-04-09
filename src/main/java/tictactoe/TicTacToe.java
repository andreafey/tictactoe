package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.common.base.Preconditions;

import tictactoe.strategy.BlockingStrategy;
import tictactoe.strategy.CenterStrategy;
import tictactoe.strategy.CombinedStrategy;
import tictactoe.strategy.CornerStrategy;
import tictactoe.strategy.RandomStrategy;
import tictactoe.strategy.Strategy;
import tictactoe.strategy.TakeWinStrategy;

public class TicTacToe {

	public static void main(String[] args) {
		Strategy strategy = new CombinedStrategy(
				new TakeWinStrategy(),
				new BlockingStrategy(),
				new CenterStrategy(), 
				new CornerStrategy(),
				new RandomStrategy());
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe");
		do {
			// play a game
			play(new Board(), strategy, reader);
			System.out.println("Do you want to play again [y/n]? ");
		} while ("y".equals(reader.next()));
		
		System.out.println("See ya!");
		reader.close();
	}
	
	public static void play(Board board, Strategy strategy, Scanner reader) {
		Preconditions.checkArgument(board.getTurn()==Player.X);
		// computer (X) goes first
		Move move = TicTacToeUtils.random(strategy.getMoves(board));
		board.move(move.getRow(), move.getCol(), move.getPlayer());
		// print board
		System.out.println(board);
		// if game over print winner and exit
		if (checkStatus(board)) {
			return;
		}
		// else move user
		else {
			// move user
			moveUser(board, reader);
		}

		// if game over print winner and exit
		if (checkStatus(board)) {
			return;
		}
		// else recursively call play
		else {
			play(board, strategy, reader);
		}
		
	}

	private static void moveUser(Board board, Scanner reader) {
		Preconditions.checkArgument(board.getTurn()==Player.O);
		System.out.println("Enter row (space) column: ");
		int col = -1;
		int row = -1;
		try {
			row = reader.nextInt();
			col = reader.nextInt();
			board.move(row, col, Player.O);
		} catch (InputMismatchException e) {
			System.out.println("Please enter ints");
			reader.nextLine(); // toss the input
			moveUser(board, reader);
			// without this return not actually exiting after recall
			//return;
		} catch(IllegalArgumentException e) {
			System.out.println("Not a valid move");
			moveUser(board, reader);
		}
	}
	
	private static boolean checkStatus(Board board) {
		if (board.isGameOver()) {
			Player winner = board.winner();
			if (winner==null) {
				System.out.println("It's a draw.");
			} else {
				System.out.println("Player "+winner+" is the winner.");
			}
			return true;
		} else {
			return false;
		}
	}

}
