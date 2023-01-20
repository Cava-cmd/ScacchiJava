package utils;

/**
 * estensione della classe Coordinate che tiene conto del pezzo che occupa la
 * posizione
 * 
 * @see utils.Coordinate
 */
public class Tile extends Coordinate {

	Piece piece;

	public Tile(int x, int y, Piece piece) {
		super(x, y);
		this.piece = piece;
	}

	public Tile(Coordinate position, Piece piece) {
		this(position.getX(), position.getY(), piece);
	}

	public Tile(Coordinate position) {
		this(position, null);
	}

	public Tile(int x, int y) {
		this(x, y, null);
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean equals(Tile obj) {
		if (obj.getPosition() == getPosition())
			return true;
		return false;
	}

	/**
	 * @return una stringa contenente le informazioni relative alla casella secondo
	 *         la formattazione UCI
	 */
	@Override
	public String toString() {
		return piece.toString() + super.toString();
	}

}
