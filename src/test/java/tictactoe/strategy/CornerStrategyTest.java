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
		
		Move move = TicTacToeUtils.random(moves); 
		board.move(move.getRow(), move.getCol(), move.getPlayer());
		moves = strategy.getMoves(board);
		assertEquals("expect three center moves left", 3, moves.size());
		
		board = new Board();
		board.move(0, 0, Player.X);
		board.move(0, 2, Player.O);
		board.move(2, 0, Player.X);
		board.move(2, 2, Player.O);
		moves = strategy.getMoves(board);
		assertEquals("expect no center moves left", 0, moves.size());
	}

}
