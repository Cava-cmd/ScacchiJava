package utils;

import java.util.Vector;

import enums.*;
import utils.pieces.*;

public class CheckBoard {

	Tile[][] board = new Tile[8][8];
	Vector<Piece> captures = new Vector<>();
	PlayerType toMove;

	public CheckBoard() {
		reset();
		toMove = PlayerType.WHITE;
	}

	/**
	 * metodo che ripristina la scacchiera alle condizioni iniziali
	 */
	public void reset() {

		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++)
				board[x][y] = new Tile(x, y, new NullPiece());

		board[0][0] = new Tile(0, 0, new Rook(PlayerType.WHITE));
		board[7][0] = new Tile(7, 0, new Rook(PlayerType.WHITE));
		board[0][7] = new Tile(0, 7, new Rook(PlayerType.BLACK));
		board[7][7] = new Tile(7, 7, new Rook(PlayerType.BLACK));

		board[1][0] = new Tile(1, 0, new Knight(PlayerType.WHITE));
		board[6][0] = new Tile(6, 0, new Knight(PlayerType.WHITE));
		board[1][7] = new Tile(1, 0, new Knight(PlayerType.BLACK));
		board[6][7] = new Tile(6, 0, new Knight(PlayerType.BLACK));

		board[2][0] = new Tile(2, 0, new Bishop(PlayerType.WHITE));
		board[5][0] = new Tile(5, 0, new Bishop(PlayerType.WHITE));
		board[2][7] = new Tile(2, 7, new Bishop(PlayerType.BLACK));
		board[5][7] = new Tile(5, 7, new Bishop(PlayerType.BLACK));

		board[3][0] = new Tile(3, 0, new Queen(PlayerType.WHITE));
		board[4][0] = new Tile(4, 0, new King(PlayerType.WHITE));
		board[3][7] = new Tile(3, 7, new Queen(PlayerType.BLACK));
		board[4][7] = new Tile(4, 7, new King(PlayerType.BLACK));

		for (int x = 0; x < 8; x++) {

			board[x][1] = new Tile(x, 1, new Pawn(PlayerType.WHITE));
			board[x][6] = new Tile(x, 6, new Pawn(PlayerType.BLACK));

		}

	}

	public Tile[][] getBoard() {
		return board;
	}

	public Tile getTile(int x, int y) {
		return board[x][y];
	}

	/**
	 * metodo che gestisce la registrazione della mossa
	 * 
	 * @return true se la mossa è valida, false in caso contrario
	 * @throws Exception - la partita è terminata per cattura del re
	 */
	public boolean makeMove(Tile start, Tile end) throws Exception {
		
		if(start.getPiece().getPlayer() != toMove)
			return false;
		
		if (!start.getPiece().isLegal(start, end))
			return false;

		if (!(end.getPiece() instanceof NullPiece)) {
			captures.add(end.getPiece());
			
			if(end.getPiece().getType() == PieceType.KING) 
				throw new Exception("game ended");
			
		}

		board[end.getX()][end.getY()].setPiece(start.getPiece());
		board[start.getX()][start.getY()].setPiece(new NullPiece());
		switch(toMove) {
		case BLACK:
			toMove = PlayerType.WHITE;
			break;
		case WHITE:
			toMove = PlayerType.BLACK;
			break;
		
		}
		return true;
	}

}
