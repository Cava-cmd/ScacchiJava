package utils;

import java.util.Vector;

import enums.*;
import utils.pieces.*;

public class CheckBoard {

	Tile[][] board = new Tile[8][8];
	Vector<Piece> captures = new Vector<>();
	// TODO implement moves log

	public CheckBoard() {
		reset();
	}

	/**
	 * metodo che ripristina la scacchiera alle condizioni iniziali
	 */
	public void reset() {

		for (Tile[] tiles : board)
			for (Tile tile : tiles)
				tile.setPiece(null);

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

	/**
	 * metodo che gestisce la registrazione della mossa
	 * 
	 * @return true se la mossa è valida, false in caso contrario
	 * @throws Exception se la mossa è scacco matto
	 */
	public boolean makeMove(Tile start, Tile end) throws Exception {
		if (!start.getPiece().isLegal(start, end))
			return false;

		if (end.getPiece() != null) {
			captures.add(end.getPiece());
			end.setPiece(null);
		}

		board[end.getX()][end.getY()] = start;
		board[start.getX()][start.getY()] = new Tile(start.getX(), start.getY(), null);
		findCheckmate();
		return true;
	}
	//TODO optimize
	private void findCheckmate() throws Exception {
		int legalMoves = 8;
		for (Tile[] tiles : board)
			for (Tile tile : tiles) {
				Piece piece = tile.getPiece();
				if (piece.equals(PieceType.KING)) {

					for (int x = tile.getX() - 1; x < tile.getX() + 1; x++)
						for (int y = tile.getY() - 1; y < tile.getY() + 1; y++) {
							if (!(x == tile.getX() && y == tile.getY()))// evita ridondanza
								try {

									if (!piece.isLegal(tile, board[x][y]))
										legalMoves--;

								} catch (ArrayIndexOutOfBoundsException e) {
								} // ignora gli errori di indice non valido
							
						}

				}
				
			}
		
		if(legalMoves <= 0) throw new Exception("Checkmate");
		
	}

}
