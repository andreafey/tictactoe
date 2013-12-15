package tictactoe.strategy;

import tictactoe.Board;
import tictactoe.Move;

public interface Strategy {
	public Move getMove(Board board);
}
