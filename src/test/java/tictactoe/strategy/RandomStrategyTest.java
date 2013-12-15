package tictactoe.strategy;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import tictactoe.Board;
import tictactoe.Move;

public class RandomStrategyTest {

	@Test
	public void testGetMove() {
		// TODO get random move 99 times from a new board
		// keep count of how many times any one move is generated
		// make sure ~ random distribution
		// everyone gets hit at least 3x
		// none gets hit 20 times
		Map<Move,Integer> count = new HashMap<>();
		Strategy strategy = new RandomStrategy();
		
		for (int i = 0; i<100; i++) {
			Board board = new Board();
			Move random = strategy.getMove(board);
			// always Player.X
			if (count.get(random) == null) {
				count.put(random, 1);
			} else {
				count.put(random, count.get(random)+1);
			}
		}
		// note since we're looking at random stuff, this is not guaranteed; should
		// pretty reliable, though
		Collection<Move> moves = count.keySet();
		assertEquals(9, moves.size());
		for (Integer tally : count.values()) {
			assertTrue(tally > 2);
			assertTrue(tally < 20);
		}
	}

}
