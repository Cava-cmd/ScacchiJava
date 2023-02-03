package utils.pieces;

import java.util.ArrayList;
import java.util.List;

import enums.PieceType;
import enums.PlayerType;
import utils.Coordinate;
import utils.Piece;
import utils.Tile;

public class Pawn extends Piece {
	// TODO fix en-passant
	// TODO implementare promozione
	public Pawn(PlayerType player) {
		super(PieceType.PAWN, player);
	}

	@Override
	public boolean isLegal(Tile start, Tile end) {

		if (end.getPiece().getPlayer() == getPlayer())
			return false;

		if (start.getPosition().equals(end.getPosition()))
			return false;
		
		//controlla se la mossa è nella direzione corretta
		switch (getPlayer()) {
		case BLACK:
			if (start.getY() < end.getY())
				return false;
			break;
		case WHITE:
			if (start.getY() > end.getY())
				return false;
			break;

		}
		//controlla se la mossa successiva è una cattura
		if (start.getX() != end.getX() && end.getPiece() instanceof NullPiece)
			return false;
		
		//controlla se è la prima mossa
		int dist = Math.abs(start.getY() - end.getY());
		if(dist > 2)
			return false;
		
		if(dist == 2) {
			if(getPlayer() == PlayerType.WHITE && start.getY() != 1)
				return false;
			else if(getPlayer() == PlayerType.BLACK && start.getY() != 6)
				return false;
		}

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
