package tictactoe.strategy;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import tictactoe.Board;
import tictactoe.Move;
import tictactoe.Player;
import tictactoe.TicTacToeUtils;

public class WinningStrategyTest {

	@Test
	public void test() {
		Board board = new Board();
		Strategy strategy = new WinningStrategy();
		Collection<Move> moves = strategy.getMoves(board);
		assertEquals("don't expect any winning moves before anything played", 0, moves.size());
		
		board.move(new Move(1, 1, Player.X));
		board.move(new Move(0, 2, Player.O));
		board.move(new Move(0, 0, Player.X));
		board.move(new Move(1, 2, Player.O));
//		  X |   | O 
//		 ____________
//		    | X | O  
//		 ____________
//		    |   |  
		moves = strategy.getMoves(board);
		assertEquals("expect X beats Player O", 1, moves.size());
		Move expected = new Move(2, 2, Player.X);
		Move result = TicTacToeUtils.random(moves);
		assertEquals("unexpected move", expected, result);
		
		board.move(result);
		assertTrue("game should be over", board.isGameOver());
	}

}
