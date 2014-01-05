package tictactoe.strategy;

import java.util.Collection;

import tictactoe.Board;
import tictactoe.Move;

public interface Strategy {
	public abstract Collection<Move> getMoves(Board board);
}
