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

		int d = Math.abs(start.getPosition().getX() - end.getPosition().getX()) + 1;
		List<Coordinate> output = new ArrayList<>();
		int startX = Math.min(start.getPosition().getX(), end.getPosition().getX());

		for (int x = startX; x < d; x++)
			output.add(new Coordinate(x, x));

		return output;
	}

}
