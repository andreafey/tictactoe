package tictactoe.strategy;

import java.util.Collection;
import java.util.HashSet;

import tictactoe.Board;
import tictactoe.Move;

/**
 * Find moves which will allow Player to win on this turn
 * @author andrea
 */
public class WinningStrategy implements Strategy {

	@Override
	public Collection<Move> getMoves(Board board) {
		Collection<Move> available = board.availableMoves();
		Collection<Move> winning = new HashSet<>();
		for (Move move : available) {
			if (isWinning(move, board)) winning.add(move);
		}
		return winning;
	}
	private boolean isWinning(Move move, Board board) {
		Board copy = board.clone();
		copy.move(move);
		return copy.isGameOver();
	}

}
