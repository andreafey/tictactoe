package tictactoe;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testMove() {
		Board board = new Board();
		// valid move
		board.move(0, 0, Player.X);
		assertEquals(1, TicTacToeUtils.movesPlayed(board, Player.X));
		assertEquals(0, TicTacToeUtils.movesPlayed(board, Player.O));
		// valid move
		board.move(1, 0, Player.O);
		assertEquals(1, TicTacToeUtils.movesPlayed(board, Player.X));
		assertEquals(1, TicTacToeUtils.movesPlayed(board, Player.O));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testMoveNotNull() {
		Board board = new Board();
		// valid move
		board.move(0, 0, Player.X);
		// not valid (not null)
		board.move(0, 0, Player.O);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testMoveOutOfTurn() {
		Board board = new Board();
		// valid move
		board.move(0, 0, Player.X);
		// not valid (out of turn)
		board.move(0, 1, Player.X);
	}

	@Test
	public void testIsGameOver() {
		Board board = nearStalemate();
		assertFalse(board.isGameOver());
	}
	@Test
	public void testIsGameOverFullBoard() {
		Board stalemate = stalemate();
		assertTrue(stalemate.isGameOver());
	}
	@Test
	public void testIsGameOverDiag1Wins() {
		Board board = xWinsDiag1();
		assertTrue(board.isGameOver());
	}
	@Test
	public void testIsGameOverDiag2Wins() {
		Board board = oWinsDiag2();
		assertTrue(board.isGameOver());
	}
	@Test
	public void testIsGameOverRowWins() {
		Board board = xWinsRow();
		assertTrue(board.isGameOver());
	}
	@Test
	public void testIsGameOverColWins() {
		Board board = xWinsCol();
		assertTrue(board.isGameOver());
	}

	@Test
	public void testWinnerDiag1() {
		Board board = xWinsDiag1();
		assertEquals(Player.X, board.winner());
	}
	@Test
	public void testWinnerDiag2() {
		Board board = oWinsDiag2();
		assertEquals(Player.O, board.winner());
	}
	@Test
	public void testWinnerRow() {
		Board board = xWinsRow();
		assertEquals(Player.X, board.winner());
	}
	@Test
	public void testWinnerCol() {
		Board board = xWinsCol();
		assertEquals(Player.X, board.winner());
	}
	
	@Test
	public void testAvailableMoves() {
		Board board = nearStalemate();
		Collection<Move> moves = board.availableMoves();
		assertEquals(1, moves.size());
		assertTrue(moves.contains(new Move(2, 2, Player.X)));
		
		board = new Board();
		moves = board.availableMoves();
		assertEquals(9, moves.size());
	}
	
	@Test
	public void testAvailableSquares() {
		Board board = nearStalemate();
		Collection<Square> squares = board.availableSquares();
		assertEquals(1, squares.size());
		assertTrue(squares.contains(new Square(2, 2)));
		
		board = new Board();
		squares = board.availableSquares();
		assertEquals(9, squares.size());
	}

	private Board stalemate() {
		Board board = nearStalemate();
		board.move(2, 2, Player.X);
		return board;
	}
	private Board nearStalemate() {
		Board board = new Board();
		board.move(1, 1, Player.X);
		board.move(0, 0, Player.O);
		board.move(1, 0, Player.X);
		board.move(1, 2, Player.O);
		board.move(0, 1, Player.X);
		board.move(2, 1, Player.O);
		board.move(2, 0, Player.X);
		board.move(0, 2, Player.O);
		return board;
	}
	private Board xWinsDiag1() {
		Board board = new Board();
		board.move(1, 1, Player.X);
		board.move(0, 2, Player.O);
		board.move(0, 0, Player.X);
		board.move(2, 1, Player.O);
		board.move(2, 2, Player.X);
		return board;
	}
	private Board oWinsDiag2() {
		Board board = new Board();
		board.move(0, 1, Player.X);
		board.move(0, 2, Player.O);
		board.move(1, 0, Player.X);
		board.move(1, 1, Player.O);
		board.move(2, 2, Player.X);
		board.move(2, 0, Player.O);
		return board;
	}
	private Board xWinsRow() {
		Board board = new Board();
		board.move(1, 1, Player.X);
		board.move(0, 2, Player.O);
		board.move(1, 0, Player.X);
		board.move(2, 1, Player.O);
		board.move(1, 2, Player.X);
		return board;
	}
	private Board xWinsCol() {
		Board board = new Board();
		board.move(1, 1, Player.X);
		board.move(2, 0, Player.O);
		board.move(0, 1, Player.X);
		board.move(1, 2, Player.O);
		board.move(2, 1, Player.X);
		return board;
	}

}
