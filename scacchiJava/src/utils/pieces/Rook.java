package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class Rook extends Piece {

	public Rook(PlayerType player) {
		super(PieceType.ROOK, player);
	}
	
	@Override
	public boolean isLegal(Tile start, Tile end) {

		if (start.getPosition().getX() == end.getPosition().getX()
				^ start.getPosition().getY() == end.getPosition().getY())
			return true;
		return false;
	}

	@Override
	public List<Coordinate> getPath(Tile start, Tile end) {
		int d = Math.abs(start.getPosition().getX() - end.getPosition().getX())
				+ Math.abs(start.getPosition().getY() - end.getPosition().getY()) + 1;

		ArrayList<Coordinate> output = new ArrayList<>();

		for (int i = 0; i < d; i++) {
			if (start.getPosition().getX() == end.getPosition().getX())
				output.add(new Coordinate(start.getPosition().getX(),
						Math.min(start.getPosition().getY(), end.getPosition().getY()) + i));
			else
				output.add(new Coordinate(Math.min(start.getPosition().getX(), end.getPosition().getX()) + i,
						start.getPosition().getY()));
		}

		return output;

	}

}
