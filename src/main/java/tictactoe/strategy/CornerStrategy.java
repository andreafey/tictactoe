package tictactoe.strategy;

import java.util.Collection;
import java.util.HashSet;

import tictactoe.Board;
import tictactoe.Move;

/**
 * Selects available Moves which are the corners of the board
 * @author andrea
 */
public class CornerStrategy implements Strategy {

	@Override
	public Collection<Move> getMoves(Board board) {
		int size = board.size();
		Collection<Move> corners = new HashSet<>();
		Collection<Move> available = board.availableMoves();
		for (Move move : available) {
			// if it's a corner
			if ((move.getRow() == 0 || move.getRow() == size - 1) &&
				(move.getCol() == 0 || move.getCol() == size - 1))
				corners.add(move);
		}
		return corners;
	}

}
