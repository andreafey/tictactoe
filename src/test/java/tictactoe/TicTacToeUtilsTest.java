package tictactoe;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

public class TicTacToeUtilsTest {

	@Test
	public void testRandom() {
		// set of integers from 0 to x
		int x = 10;
		int depth = 100;
		Set<Integer> set = ContiguousSet.create(Range.closed(0, x-1), DiscreteDomain.integers());
		int[] tallies = new int[x];
		for (int i=0; i<x*depth; i++) {
			Integer rand = TicTacToeUtils.random(set);
			tallies[rand] = tallies[rand]+1;
		}
		// expect more or less even distribution, so about 100 in each; not guaranteed, of course
		int expected = (int) (depth * 0.8);
		for (int tally : tallies) {
			assertTrue("did not achieve acceptable random distribution: "+tally, tally > expected);
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRandomEmpty() {
		TicTacToeUtils.random(new HashSet<>());
	}

}
