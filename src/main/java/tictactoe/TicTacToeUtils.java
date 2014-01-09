package tictactoe;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class TicTacToeUtils {
	/**
	 * Select a random Collection member
	 * @param collection any Collection
	 * @return a random Collection member
	 */
	public static <T> T random(Collection<T> collection) {
		List<T> list = Lists.newArrayList(collection);
		Collections.shuffle(list);
		return list.get(0);
	}
	/**
	 * Count moves made by a player
	 * @param board the Board to examine
	 * @param player the Player to consider
	 * @return the number of moves player has made
	 */
	public static int movesPlayed(Board board, Player player) {
		Collection<Player> played = board.squaresPlayed().values();
		return Collections2.filter(played, Predicates.equalTo(player)).size();
	}
}
