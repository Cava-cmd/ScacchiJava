package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class NullPiece extends Piece {

	public NullPiece() {
		super(PieceType.NULL, PlayerType.NULL);
	}

	@Override
	protected boolean isLegal(Tile start, Tile end) {
		return false;
	}

	@Override
	public List<Coordinate> getPath(Tile start, Tile end) {
		return new ArrayList<Coordinate>();
	}

}
