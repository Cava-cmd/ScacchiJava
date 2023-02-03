package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;
//TODO aggiungere scacco e scacco matto
public class King extends Piece {

	public King(PlayerType player) {
		super(PieceType.KING, player);
	}

	@Override
	public boolean isLegal(Tile start, Tile end) {
		
		if(end.getPiece().getPlayer() == start.getPiece().getPlayer())
			return false;
		
		int difference = Math.abs(start.getPosition().getX() - end.getPosition().getX())
				+ Math.abs(start.getPosition().getY() - end.getPosition().getY());
		
		if(difference == 1)
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
