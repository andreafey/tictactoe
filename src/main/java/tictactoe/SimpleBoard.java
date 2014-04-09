package tictactoe;

import java.util.Arrays;

import com.google.common.base.Strings;

public class SimpleBoard {
	  public String[][] grid;
	  public SimpleBoard() {
	    grid = new String[3][3];
	    for (int i=0; i<3; i++) {
	        Arrays.fill(grid[i], "");
	    }
	  }
	  public void move(String player, int row, int col) {
	    grid[row][col] = player;
	  }
	  public boolean gameOver() {
	    if (isWinner("x") || isWinner("o")) return true;
	    else if (isBoardFull()) return true;
	    else return false;
	  }
	  public boolean isWinner(String player) {
	    for (String[] line : getLines()) {
	      if (allSame(player, line)) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  public String[][] getLines() {
	    String[][] lines = {
	    		// rows
	    		{grid[0][0], grid[0][1], grid[0][2]},
	    		{grid[1][0], grid[1][1], grid[1][2]},
	    		{grid[2][0], grid[2][1], grid[2][2]},
	    		// cols
	    		{grid[0][0], grid[1][0], grid[2][0]},
	    		{grid[0][1], grid[1][1], grid[2][1]},
	    		{grid[0][2], grid[1][2], grid[2][2]},
	    		// diags
	    		{grid[0][0], grid[1][1], grid[2][2]},
	    		{grid[0][2], grid[1][1], grid[2][0]},
	    		};
	    return lines;
	  }
	  public boolean allSame(String player, String[] items) {
	    for (String item : items) {
	      if (!player.equals(item)) return false;
	    }
	    return true;
	  }
	  public boolean isBoardFull() {
	    for (int i=0; i<3; i++) {
	      for (int j=0; j<3; j++) {
	        if ("".equals(grid[i][j])) return false;
	      }
	    }
	    return true;
	  }
		@Override
		public String toString() {
			int size = 3;
			String newLine = System.lineSeparator();
			String board = "Tic Tac Toe"+newLine+newLine;
			for (int row = 0; row < size; ) {
				for (int col = 0; col < size; ) {
					String player = grid[row][col];
					board += " " + ("".equals(player) ? " " : player) + " ";
					if (++col < size) board += "|";
				}
				if (++row < size) board += newLine+Strings.repeat("_", (size*4))+newLine;
			}
			return board+newLine;
		}
	}

