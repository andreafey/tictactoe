package tictactoe.strategy;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import tictactoe.Board;
import tictactoe.Move;
import tictactoe.Player;
import tictactoe.TicTacToeUtils;

public class CornerStrategyTest {

	@Test
	public void test() {
		Strategy strategy = new CornerStrategy();
		Board board = new Board();
		Collection<Move> moves = strategy.getMoves(board);
		assertEquals("expect exactly four moves - the corners", 4, moves.size());
		
		board.move(TicTacToeUtils.random(moves));
		moves = strategy.getMoves(board);
		assertEquals("expect three center moves left", 3, moves.size());
		
		board = new Board();
		board.move(new Move(0, 0, Player.X));
		board.move(new Move(0, 2, Player.O));
		board.move(new Move(2, 0, Player.X));
		board.move(new Move(2, 2, Player.O));
		moves = strategy.getMoves(board);
		assertEquals("expect no center moves left", 0, moves.size());
	}

}
