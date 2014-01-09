package tictactoe;

import com.google.common.base.Objects;

public class Square {
	private int row;
	private int col;
	
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(row).addValue(col).toString();
	}
	@Override
	public boolean equals(Object o) {
		if (o==null) return false;
		else if (this==o) return true;
		else if (o.getClass()==getClass()){
			Square sq = (Square) o;
			return Objects.equal(row, sq.getRow())
					&& Objects.equal(col, sq.getCol());
		}
		else return false;
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(row, col);
	}

}
