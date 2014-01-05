package tictactoe.strategy;

import java.util.Collection;
import java.util.HashSet;

import tictactoe.Board;
import tictactoe.Move;

public class CombinedStrategy implements Strategy {
	
	private final Strategy[] strategies;
	
	// These should already be ordered by priority
	public CombinedStrategy(Strategy... strategies) {
		this.strategies = strategies;
	}

	// TODO my initial assumption was that a strategy could supply moves which meet that 
	// strategy, and subsequent strategies could narrow that list down
	// however, in practice with my existing strategies, that initial list is not narrowed
	@Override
	public Collection<Move> getMoves(Board board) {
		Collection<Move> all = new HashSet<>();
		for (Strategy strategy : strategies) {
			// find moves which meet this strategy as well as any of higher priority
			Collection<Move> moves = strategy.getMoves(board);
			if (moves.isEmpty()) {
				continue;
			}
			else if (all.isEmpty()) {
				all.addAll(moves);
			}
			else {
				Collection<Move> intersect = intersection(all, moves);
				// if the current strategy does not overlap the previously examined strategies, 
				// don't reduce it
				if (!intersect.isEmpty()) all = intersect;
			}
			if (all.size() == 1) {
				// we've found a single Move of a higher priority
				return all;
			}
		}
		return all;
	}

	private Collection<Move> intersection(Collection<Move> a, Collection<Move> b) {
		Collection<Move> intersect = new HashSet<>();
		for (Move move : a) {
			if (b.contains(move)) intersect.add(move);
		}
		return intersect;
	}

}
