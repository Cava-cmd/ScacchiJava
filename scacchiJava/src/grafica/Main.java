package grafica;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GraphicBoard b = new GraphicBoard();
        b.initialize();
        b.setVisible(true);
    }
}
