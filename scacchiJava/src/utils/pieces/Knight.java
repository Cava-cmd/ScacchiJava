package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class Knight extends Piece {

	public Knight(PlayerType player) {
		super(PieceType.KNIGHT, player);
	}

	@Override
	public boolean isLegal(Tile start, Tile end) {

		int startCoordinate = 8 * start.getPosition().getY() + start.getPosition().getX();
		int endCoordinate = 8 * end.getPosition().getY() + end.getPosition().getX();
		int difference = Math.abs(endCoordinate - startCoordinate);
		if (difference == 0)
			return false;
		
		if(difference == 6 || difference == 10 || difference == 15 || difference == 17)
			return true;
		
		return false;
	}

	@Override
	public List<Coordinate> getPath(Tile start, Tile end) {
		List<Coordinate> output = new ArrayList<>();
		output.add(start.getPosition());
		output.add(end.getPosition());
		return output;
	}

}
