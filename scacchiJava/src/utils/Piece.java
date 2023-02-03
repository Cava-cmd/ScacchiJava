package utils;

import java.util.List;

import enums.*;

public abstract class Piece {

	private PieceType type;
	private PlayerType player;

	public Piece(PieceType type, PlayerType player) {

		this.type = type;
		this.player = player;

	}

	public PieceType getType() {
		return type;
	}

	public PlayerType getPlayer() {
		return player;
	}
	/**verifica se la mossa è valida
	 * @param start - il quadrato iniziale
	 * @param end - il quadrato finale
	 */
	protected abstract boolean isLegal(Tile start, Tile end);
	
	/**
	 * @param start - il quadrato iniziale
	 * @param end - il quadrato finale
	 * @return una lista contenente le coordinate attraversate dal pezzo
	 */
	public abstract List<Coordinate> getPath(Tile start, Tile end);
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Piece || obj instanceof PieceType))
			return false;
		
		if(obj instanceof Piece)
			return ((Piece) obj).getType() == getType();
		if (obj instanceof PieceType)
			return obj == getType();
		
		return true;
		
	}
	
	@Override
	public String toString() {
		return type.value;
	}

}
