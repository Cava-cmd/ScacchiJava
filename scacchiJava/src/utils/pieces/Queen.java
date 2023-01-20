package utils.pieces;

import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class Queen extends Piece {

	public Queen(PlayerType player) {
		super(PieceType.QUEEN, player);
	}
	Bishop bishop = new Bishop(null);
	Rook rook = new Rook(null);

	@Override
	public boolean isLegal(Tile start, Tile end) {
		
		if(bishop.isLegal(start, end) || rook.isLegal(start, end))
			return true;
		
		return false;
	}

	@Override
	public List<Coordinate> getPath(Tile start, Tile end) {
		
		List<Coordinate> output = null;
		if(bishop.isLegal(start, end))
			output = bishop.getPath(start, end);
		
		if(rook.isLegal(start, end))
			output = rook.getPath(start, end);
		
		return output;
	}

}
