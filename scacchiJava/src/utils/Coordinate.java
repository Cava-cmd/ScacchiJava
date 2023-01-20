package utils;

/**
 * classe utilizzata per semplificare la gestione delle coordinate di ogni pezzo sulla scacchiera
 * @see utils.Tile
 */

public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * @return l'istanza della classe coordinate
	 */
	public Coordinate getPosition() {
		return new Coordinate(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < 8 && x > 0)
			this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < 8 && y > 0)
			this.y = y;
	}

	public boolean equals(Coordinate obj) {
		if (obj.getX() == getX() && obj.getY() == getY())
			return true;
		return false;
	}

	@Override
	public String toString() {
		String location = "";
		switch (y) {
		case 0:
			location += "a";
			break;
		case 1:
			location += "b";
			break;
		case 2:
			location += "c";
			break;
		case 3:
			location += "d";
			break;
		case 4:
			location += "e";
			break;
		case 5:
			location += "f";
			break;
		case 6:
			location += "g";
			break;
		case 7:
			location += "h";
			break;
		}
		location += String.valueOf(x);

		return location;
	}

}
