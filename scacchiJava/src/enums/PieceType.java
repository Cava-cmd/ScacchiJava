package enums;

public enum PieceType {
	
	KING("K", "♚"),
	QUEEN("Q", "♛"),
	ROOK("R", "♜"),
	KNIGHT("N", "♞"),
	BISHOP("B", "♝"),
	PAWN("", "♟"),
	NULL("", " ");

	public String value;
	public String character;
	PieceType(String value, String character) {
		this.value = value;
		this.character = character;
	}
}
