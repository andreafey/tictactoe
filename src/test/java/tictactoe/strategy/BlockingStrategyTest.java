package tictactoe.strategy;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import tictactoe.Board;
import tictactoe.Move;
import tictactoe.Player;
import tictactoe.TicTacToeUtils;

public class BlockingStrategyTest {

	@Test
	public void test() {
		Board board = new Board();
		Strategy strategy = new BlockingStrategy();
		Collection<Move> moves = strategy.getMoves(board);
		assertEquals("don't expect any blocking moves before anything played", 0, moves.size());
		
		board.move(new Move(1, 1, Player.X));
		board.move(new Move(1, 0, Player.O));
		board.move(new Move(0, 0, Player.X));
//		  X |   |   
//		 ____________
//		  O | X |   
//		 ____________
//		    |   |  
		
		moves = strategy.getMoves(board);
		assertEquals("expect O blocks Player X", 1, moves.size());
		Move expected = new Move(2, 2, Player.O);
		assertEquals("unexpected move", expected, TicTacToeUtils.random(moves));
		
		board = new Board();
		board.move(new Move(2, 2, Player.X));
		board.move(new Move(0, 0, Player.O));
		board.move(new Move(1, 1, Player.X));
		board.move(new Move(0, 1, Player.O));
//		  O | O |   
//		 ____________
//		    | X |   
//		 ____________
//		    |   | X 
		
		moves = strategy.getMoves(board);
		assertEquals("expect X blocks Player O", 1, moves.size());
		expected = new Move(0, 2, Player.X);
		assertEquals("unexpected move", expected, TicTacToeUtils.random(moves));

	}

}
