package denis.korchagin;

import java.awt.*;

public class Tractor {

    public static void drawTractor(Graphics2D g, int r1, int r2, int r3, int r4, int x, int y, int weight, int height,
                                    Color[] c) {
        Color oldC = g.getColor();
        BasicStroke oldStroke = (BasicStroke) g.getStroke();
        drawCabin(g, x, y, weight, height, c[0]);
        drawCabin(g, x + r2 / 2, y + height / 2 - (int)(1.35 * height), weight / 3, (int)(1.35 * height), c[1]);
        drawWing(g, x - r2 / 2, y + height - r2, 2 * r2, 2 * r2, 0, 135, c[2]);
        drawWing(g, x + weight - 2 * r1, y + height - r1 + (r4 - r3), 2 * r1, 2 * r1, 90, 90, c[2]);
        drawHeadlight(g, x + 9 * weight / 10, y + height / 10, weight / 10, height / 5,
                weight / 20, height / 10, c[3]);
        drawWindow(g, new int[] {x + r2 / 2 + weight / 30, x + r2 / 2 + 2 * weight / 15, x + r2 / 2 + 2 * weight / 15, x + r2 / 2 + weight / 30},
                new int[] {y + height / 2 - (int)(1.215 * height), y + height / 2 - (int)(1.215 * height), y, y}, c[4]);
        drawWindow(g, new int[] {x + r2 / 2 + 5 * weight / 30, x + r2 / 2 + 3 * weight / 10, x + r2 / 2 + 3 * weight / 10,
                        x + r2 / 2 + 7 * weight / 30, x + r2 / 2 + 5 * weight / 30},
                new int[] {y + height / 2 - (int)(1.215 * height), y + height / 2 - (int)(1.215 * height), y + height / 2 - (int)(0.135 * height),
                        y + height / 2 - (int)(0.135 * height), y}, c[4]);
        drawWheels(g, x - r2 / 2 + (r2 - r4), y + height - r2 + (r2 - r4), 2 * r4, 2 * r4, c[5], c[6]);
        drawWheels(g, x + weight - 2 * r1 + (r1 - r3), y + height - r3 + (r4 - r3), 2 * r3, 2 * r3, c[5], c[6]);
        drawPipe(g, x + 7 * weight / 10, y - 2 * height / 3, weight / 10, 2 * height / 3, c[1], c[5]);
        g.setColor(oldC);
        g.setStroke(oldStroke);
    }

    private static void drawCabin(Graphics2D g, int x, int y, int weight, int height,
                                  Color c) {
        g.setColor(c);
        g.fillRect(x, y, weight, height);
    }

    private static void drawWing(Graphics2D g, int x, int y, int weight, int height, int sa, int a,
                                 Color c) {
        g.setColor(c);
        g.fillArc(x, y, weight, height, sa, a);
    }

    private static void drawHeadlight(Graphics2D g, int x, int y, int weight, int height, int aw, int ah,
                                      Color c) {
        g.setColor(c);
        g.fillRoundRect(x, y, weight, height, aw, ah);
    }

    private static void drawWindow(Graphics2D g, int[] x, int[] y, Color c) {
        g.setColor(c);
        g.fillPolygon(x, y, x.length);
    }

    private static void drawWheels(Graphics2D g, int x, int y, int weight, int height, Color c1, Color c2) {
        g.setColor(c1);
        g.fillOval(x, y, weight, height);
        g.setColor(c2);
        g.fillOval(x + weight / 6, y + weight / 6, 2 * weight / 3, 2 * height / 3);
        g.setColor(c1);
        g.fillOval(x + 7 * weight / 18, y + 7 * height / 18, 2 * weight / 9, 2 * height / 9);
        double da = 2 * Math.PI / 5;
        for (int j = 0; j < 5; j++) {
            double a = j * da;
            double x1 = x + (double)(weight / 2) + weight * 2 * Math.cos(a) / 9;
            double y1 = y + (double)(height / 2) + height * 2 * Math.sin(a) / 9;
            g.fillOval((int)(x1 - weight / 18), (int)(y1 - height / 18), weight / 9, height / 9);
        }
    }

    private static void drawPipe(Graphics2D g, int x, int y, int weight, int height,
                                 Color c1, Color c2) {
        g.setColor(c1);
        g.fillRect(x, y, weight, height);
        g.setColor(c2);
        g.setStroke(new BasicStroke(10));
        g.drawArc(x + weight / 2, y - height / 2, 2 * weight, height,180, -95);
    }
}
