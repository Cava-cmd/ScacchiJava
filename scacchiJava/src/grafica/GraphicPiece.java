package grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import utils.Piece;

public class GraphicPiece extends JButton {

	Piece piece;
	
	public GraphicPiece(Piece piece) {
		this.piece = piece;
		setOpaque(true);
		
	}
	
	 @Override
	public void paint(Graphics g) {
		 String inputFile = piece.getType().value + piece.getPlayer().value + ".png";
		 
		 try {
			BufferedImage image = ImageIO.read(new File(inputFile));
			g.drawImage(image, 0, 0, null);
		} catch (IOException e) {}
		 
	}
	
}
