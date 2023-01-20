package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class Pawn extends Piece {

	public Pawn(PlayerType player) {
		super(PieceType.PAWN, player);
	}

	@Override
	public boolean isLegal(Tile start, Tile end) {

		if (start.getPosition().equals(end.getPosition()))
			return false;

		if (Math.abs(start.getPosition().getX() - end.getPosition().getX()) == 2)
			// first pawn move
			switch (super.getPlayer()) {
			case BLACK:
				if (start.getPosition().getX() != 6)
					return false;
			case WHITE:
				if (start.getPosition().getX() != 1)
					return false;
			}

		if (Math.abs(start.getPosition().getX() - end.getPosition().getX()) == 1)
			;
		return true;
	}

	@Override
	public List<Coordinate> getPath(Tile start, Tile end) {

		List<Coordinate> output = new ArrayList<>();

		int d = Math.abs(start.getPosition().getY() - end.getPosition().getY()) + 1;

		for (int i = 0; i < d; i++) {
			output.add(new Coordinate(start.getPosition().getX(),
					Math.min(start.getPosition().getY(), end.getPosition().getY()) + i));
		}

		return output;
	}

}
