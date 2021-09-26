package denis.korchagin;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D)g;
        drawBackground(gr, 0, 0, getWidth(), getHeight() / 2, Color.BLUE);
        drawBackground(gr, 0, getHeight() / 2, getWidth(), getHeight() / 2, Color.GREEN);
        Tractor.drawTractor(gr, 63, 75, 48, 60, getWidth() / 2, 2 * getHeight() / 3, 300, 96,
                new Color[] {Color.darkGray, Color.GRAY, Color.BLUE, Color.ORANGE, Color.CYAN, Color.BLACK, Color.WHITE});
        Snow.drawSnow(gr, 30, getWidth(), getHeight(), Color.WHITE, 11, 16);
        drawMoon(gr,3 * getWidth() / 4, getHeight() / 4, 50, Color.ORANGE);
    }

    private static void drawBackground(Graphics2D g, int x, int y, int w, int h, Color c) {
        Color oldC = g.getColor();
        g.setColor(c);
        g.fillRect(x, y, w, h);
        g.setColor(oldC);
    }


    private static void drawMoon(Graphics2D g, int x, int y, int r, Color c) {
        Color oldC = g.getColor();
        g.setColor(c);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
        g.setColor(oldC);
    }

}
