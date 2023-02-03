package grafica;

import javax.swing.*;

import enums.PieceType;
import utils.CheckBoard;
import utils.Tile;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicBoard extends JFrame implements MouseListener {

	private CheckBoard board = new CheckBoard();
	private GraphicPiece[][] pieces = new GraphicPiece[8][8];

	private Point selection;

	public void initialize() {
		setTitle("Scacchiera - by Daniel Trimi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(new GridLayout(8, 8));
		addMouseListener(this);

		repaint();
	}

	@Override
	public void repaint() {
		Container content = getContentPane();

		content.removeAll();
		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++)
				pieces[x][y] = new GraphicPiece(board.getTile(x, y));

		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++) {
				GraphicPiece piece = pieces[x][y];

				piece.mapTo(x, y);
				content.add(piece);
			}

		content.revalidate();
	}

	public void movePiece(Point from, Point to) {
		Tile 
			fromTile = board.getTile(from.x, from.y), 
			toTile = board.getTile(to.x, to.y);
		
		try {
			board.makeMove(fromTile, toTile);
		} catch (Exception e) {
			
			JFrame messagebox = new JFrame();
			Container c = messagebox.getContentPane();
			JLabel label = new JLabel("partita terminata");
			c.add(label);
			
			messagebox.setAlwaysOnTop(true);
			messagebox.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			messagebox.setSize(200, 200);
			
			messagebox.setVisible(true);
			board.reset();
			
		}

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int y = Math.floorDiv(e.getX() - getInsets().left, getWidth() / 8);
		int x = Math.floorDiv(e.getY() - getInsets().top, getHeight() / 8);

		if (selection == null) {
			selection = new Point(x, y);
			pieces[x][y].setBackground(Color.GRAY);
		} else if (selection.x == x && selection.y == y) {
			pieces[selection.x][selection.y].mapTo(selection.x, selection.y);
			selection = null;
		} else {
			movePiece(selection, new Point(x, y));
			selection = null;
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
