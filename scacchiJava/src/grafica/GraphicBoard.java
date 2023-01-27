package grafica;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import utils.CheckBoard;
import utils.Coordinate;
import utils.Tile;

@SuppressWarnings("serial")
public class GraphicBoard extends JFrame implements MouseListener {

	CheckBoard board = new CheckBoard();
	
	public GraphicBoard() {
		
		setTitle("Scacchiera");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(8, 8));
        addMouseListener(this);

        repaint();
		
	}
	
	@Override
	public void repaint() {
		
		Container contentPane = getContentPane();
		contentPane.removeAll();
		
		for(int x = 0; x < 8; x++)
			for(int y = 0; y < 8; y++) {
				
				
				
			}
		
	}
	
	public void move(Tile start, Tile end) {
		
		board.makeMove(start, end);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
