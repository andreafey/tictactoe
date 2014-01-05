package tictactoe.strategy;

import java.util.Collection;
import java.util.HashSet;

import tictactoe.Board;
import tictactoe.Move;

/**
 * Selects a single Move, the center of the board
 * @author andrea
 */
public class CenterStrategy implements Strategy {

	@Override
	public Collection<Move> getMoves(Board board) {
		int size = board.size();
		Collection<Move> centers = new HashSet<>();
		Collection<Move> available = board.availableMoves();
		
		if (size % 2 == 1) {
			int center = size / 2;
			for (Move move : available) {
				if (move.getRow() == center && move.getCol() == center) {
					centers.add(move);
					break;
				}
			}
		}
		return centers;
	}

}
