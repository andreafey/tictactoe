package tictactoe.strategy;

import java.util.Collection;
import java.util.HashSet;

import tictactoe.Board;
import tictactoe.Move;

/**
 * Plays a Move which blocks the opponent from winning
 * @author andrea
 */
public class BlockingStrategy implements Strategy {

	@Override
	public Collection<Move> getMoves(Board board) {
		Collection<Move> available = board.availableMoves();
		Collection<Move> blocking = new HashSet<>();
		for (Move move : available) {
			if (isBlocking(move, board)) blocking.add(move);
		}
		return blocking;
	}
	/**
	 * Returns true if the move is one which blocks the opponent from winning
	 * @param move The move to consider
	 * @param board The board to examine
	 * @return true if the move is one which blocks the opponent from winning
	 */
	private boolean isBlocking(Move move, Board board) {
		// reverse the board to test the opponent's move
		Board copy = board.clone();
		copy.move(move.getRow(), move.getCol(), move.getPlayer().opponent(), true);
		return copy.isGameOver();
	}

}
