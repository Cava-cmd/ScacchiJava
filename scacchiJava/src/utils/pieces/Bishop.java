package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class Bishop extends Piece {

	public Bishop(PlayerType player) {
		super(PieceType.BISHOP, player);
	}

	@Override
	public boolean isLegal(Tile start, Tile end) {

		if (start.getPosition().equals(end.getPosition()))
			return false;

		int differenceX = Math.abs(start.getPosition().getX() - end.getPosition().getX());
		int differenceY = Math.abs(start.getPosition().getY() - end.getPosition().getY());

		if (differenceX != differenceY)
			return false;

		return true;
	}

	@Override
	public List<Coordinate> getPath(Tile start, Tile end) {

		if (!isLegal(start, end))
			return null;

		List<Coordinate> output = new ArrayList<>();
		int startX = start.getX(), endX = end.getX();
		int startY = start.getY(), endY = end.getY();
		double radCoeff = Math.toRadians((startY - endY) / (startX - endX));

		int m = (int) Math.round(Math.tan(radCoeff));
		int dir = (int) Math.round(Math.cos(radCoeff));

		if (dir > 0)
			for (int x = startX; x < endX; x++) {
				int y = x - startX + startY; // y - y0 = 1 * (x - x0)
				output.add(new Coordinate(x, y));
			}
		else if (dir < 0)
			for (int x = startX; x > endX; x--) {
				int y = -(x - startX) + startY; // y - y0 = -1 * (x - x0)
				System.out.println(x + ", " + y);
				output.add(new Coordinate(x, y));
			}
		return output;
	}

}
