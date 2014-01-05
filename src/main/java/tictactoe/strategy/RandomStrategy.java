package tictactoe.strategy;

import java.util.Collection;

import tictactoe.Board;
import tictactoe.Move;

/**
 * Select any available move randomly
 * @author andrea
 */
public class RandomStrategy implements Strategy {

	@Override
	public Collection<Move> getMoves(Board board) {
		return board.availableMoves();
	}

}
