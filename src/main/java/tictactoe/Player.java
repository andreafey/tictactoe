package tictactoe;

public enum Player {
	X, O;
	
	public boolean equals(Player other) {
		if (other==null) return false;
		else return this == other;
	}
	public String toString() {
		return this.name();
	}
}
