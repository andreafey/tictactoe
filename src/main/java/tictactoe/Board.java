package tictactoe;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class Board {
	private static final int SIZE = 3;
	private Player[][] grid;
	private Player turn;
	private Player winner;
	
	public Board() {
		grid = new Player[SIZE][SIZE];
		for (int row = 0; row<SIZE; row++) {
			for (int col = 0; col<SIZE; col++) {
				grid[row][col] = null;
			}
		}
		winner = null;
		turn = Player.X;
	}
	
	/**
	 * Player moves to grid point if allowed
	 * @param row the row to play
	 * @param col the col to play
	 * @throws IllegalArgumentException if block not available or not player's turn
	 */
	public void move(int row, int col, Player player) {
		move(row, col, player, false);
	}
	// TODO not liking this strategy-driven overload
	public void move(int row, int col, Player player, boolean overrideTurn) {
		// validate game is not already over
		Preconditions.checkArgument(!isGameOver(), "Game already over");
		// validate valid grid point
		Preconditions.checkArgument(row<SIZE && col<SIZE, "Row/Col must each be <"+SIZE);
		// validate the correct player is going
		if (!overrideTurn) Preconditions.checkArgument(turn == player, "Not your turn");
		// validate the grid cell has not already been played
		Preconditions.checkArgument(grid[row][col] == null, "Spot already taken");
		grid[row][col] = player;
		turn = player == Player.X ? Player.O : Player.X;
	}
	/**
	 * Return true if the game has ended; either the board is full or someone has won
	 * @return true if the game has ended
	 */
	public boolean isGameOver() {
		if (winner()!=null) return true;
		else return isBoardFull();
	}
	/**
	 * Determine whether a winner has been chosen; if so set it
	 * @return the winning Player or null if one has not yet been determined
	 */
	public Player winner() {
		if (winner==null) {
			// if a player has won, set winner
			// see if either diagonal contains winners
			Player[] diag1 = new Player[SIZE];
			Player[] diag2 = new Player[SIZE];
			// see if any rows contain winners
			for (int row = 0; row<SIZE; row++) {
				Player[] slice = grid[row];
				if (allSame(slice)) {
					winner = slice[0];
					break;
				}
				diag1[row] = grid[row][row];
				diag2[row] = grid[row][SIZE-row-1];
			}
			if (winner==null) {
				if (allSame(diag1)) {
					winner = diag1[0];
				} else if (allSame(diag2)) {
					winner = diag2[0];
				} else {
					// see if any columns contain winners
					for (int col = 0; col<SIZE; col++) {
						Player[] slice = new Player[SIZE];
						for (int row = 0; row<SIZE; row++) {
							slice[row] = grid[row][col]; 
							if (allSame(slice)) {
								winner = slice[0];
								break;
							}
						}
					}
				}
			}
		}
		return winner;
	}
	/**
	 * Return true if all members of the slice belong to the same player
	 * @param slice The row/column/diagonal to consider
	 * @return true if all members of the slice belong to the same player
	 */
	private boolean allSame(Player[] slice) {
		Player head = slice[0];
		if (head!=null) {
			for (int i = 1; i<SIZE; i++) {
				if (!head.equals(slice[i])) return false;
			}
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Return the player whose turn it is
	 * @return the player whose turn it is
	 */
	public Player getTurn() {
		return turn;
	}
	/**
	 * Return a Collection<Move> which have not been played
	 * @return Collection<Move> which have not been played
	 */
	public Collection<Move> availableMoves() {
		Set<Move> moves = new HashSet<>();
		for (int row = 0; row<SIZE; row++) {
			for (int col = 0; col<SIZE; col++) {
				if (grid[row][col] == null) moves.add(new Move(row, col, turn));
			}
		}
		return moves;
	}
	/**
	 * Return a Collection<Square> which have not been played
	 * @return Collection<Square> which have not been played
	 */
	public Collection<Square> availableSquares() {
		Set<Square> squares = new HashSet<>();
		for (int row = 0; row<SIZE; row++) {
			for (int col = 0; col<SIZE; col++) {
				if (grid[row][col] == null) squares.add(new Square(row, col));
			}
		}
		return squares;
	}
	/**
	 * Return a Map<Square,Player> of moves played
	 * @return moves played
	 */
	public Map<Square, Player> squaresPlayed() {
		Map<Square,Player> map = new HashMap<>();
		for (int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				if (grid[i][j] != null) {
					map.put(new Square(i, j), grid[i][j]);
				}
			}
		}
		return map;
	}

	/**
	 * Return the width of the square board
	 */
	public int size() {
		return SIZE;
	}
	/**
	 * Return true if board is full: there are no moves left to play
	 * @return true if board is full
	 */
	private boolean isBoardFull() {
		return availableSquares().size() == 0;
	}
	
	@Override
	public String toString() {
		String newLine = System.lineSeparator();
		String board = "Tic Tac Toe"+newLine+newLine;
		for (int row = 0; row<SIZE; ) {
			for (int col = 0; col<SIZE; ) {
				Player player = grid[row][col];
				board += " " + (player==null?" ":player.name()) + " ";
				if (++col < SIZE) board += "|";
			}
			if (++row < SIZE) board += newLine+Strings.repeat("_", (SIZE*4))+newLine;
		}
		return board+newLine;
	}
	public Board clone() {
		Board board = new Board();
		board.turn = this.turn;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (this.grid[i][j] != null) board.grid[i][j] = this.grid[i][j];
			}
		}
		board.winner = this.winner;
		return board;
	}
}
