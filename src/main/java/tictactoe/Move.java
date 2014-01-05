package tictactoe;

import com.google.common.base.Objects;

public class Move {
	private int row;
	private int col;
	private Player player;
	
	public Move(int row, int col, Player player) {
		this.row = row;
		this.col = col;
		this.player = player;
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public Player getPlayer() {
		return player;
	}
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(row).addValue(col).addValue(player).toString();
	}
	@Override
	public boolean equals(Object o) {
		if (o==null) return false;
		else if (this==o) return true;
		else if (o.getClass()==getClass()){
			Move m = (Move) o;
			return Objects.equal(row, m.getRow())
					&& Objects.equal(col, m.getCol())
					&& Objects.equal(player, m.player);
		}
		else return false;
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(row, col, player);
	}
	@Override
	public Move clone() {
		return new Move(row, col, player);
	}

}
