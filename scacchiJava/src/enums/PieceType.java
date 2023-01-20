package enums;

public enum PieceType {
	
	KING("K"),
	QUEEN("Q"),
	ROOK("R"),
	KNIGHT("N"),
	BISHOP("B"),
	PAWN("");

	public String value;
	PieceType(String value) {
		this.value = value;
	}
	
}
