package tictactoe.strategy;

import java.util.Collections;
import java.util.List;

import tictactoe.Board;
import tictactoe.Move;
import tictactoe.Player;

import com.google.common.collect.Lists;

public class RandomStrategy implements Strategy {

	@Override
	public Move getMove(Board board) {
		List<Move> moves = Lists.newArrayList(board.availableMoves());
		Collections.shuffle(moves);
		return moves.get(0);
	}

}
