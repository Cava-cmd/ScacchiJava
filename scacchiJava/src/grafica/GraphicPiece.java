package grafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import enums.PlayerType;
import utils.Tile;

public class GraphicPiece extends JLabel {

	private final static Font LABEL_FONT = new Font("DejaVu Sans", Font.PLAIN, 45);

	private final static Color BG_WHITE = new Color(232, 212, 186);
	private final static Color BG_BLACK = new Color(130, 30, 0);

	private final static Color FG_WHITE = new Color(255, 255, 255);
	private final static Color FG_BLACK = new Color(0, 0, 0);

	private Tile tile;

	public GraphicPiece(Tile tile) {
		super(tile.getPiece().getType().character);
		this.tile = tile;

		setFont(LABEL_FONT);
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setForeground(tile.getPiece().getPlayer() == PlayerType.WHITE ? FG_WHITE : FG_BLACK);

	}

	public void mapTo(int x, int y) {

		setBackground((x + y) % 2 == 0 ? BG_BLACK : BG_WHITE);
	}

}
