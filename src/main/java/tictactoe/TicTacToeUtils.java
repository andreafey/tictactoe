package tictactoe;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

}
