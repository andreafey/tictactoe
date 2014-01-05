package tictactoe.strategy;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import tictactoe.Board;
import tictactoe.Move;
import tictactoe.TicTacToeUtils;

public class CenterStrategyTest {

	@Test
	public void test() {
		Strategy strategy = new CenterStrategy();
		Board board = new Board();
		Collection<Move> moves = strategy.getMoves(board);
		assertEquals("expect exactly one move - the center", 1, moves.size());
		
		
		board.move(TicTacToeUtils.random(moves));
		moves = strategy.getMoves(board);
		assertEquals("no center moves left", 0, moves.size());
	}

}
