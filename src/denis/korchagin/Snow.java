package denis.korchagin;

import java.awt.*;

public class Snow {
    private static double[] x;
    private static double[] y;

    static {
        x = new double[100];
        y = new double[100];
        for (int i = 0; i < 100; i++) {
            x[i] =  Math.random();
            y[i] = Math.random();
        }
    }


    public static void drawSnow(Graphics2D g, int n, int w, int h, Color c, int l, int n1) {
        Color oldC = g.getColor();
        g.setColor(c);
        for (int i = 0; i < n; i++) {
            double da = 2 * Math.PI / n1;
            for (int j = 0; j < n1; j++) {
                double a = j * da;
                double x1 = x[i] * w + l * Math.cos(a);
                double y1 = y[i] * h + l * Math.sin(a);
                g.drawLine((int)(x[i] * w), (int)(y[i] * h), (int)x1, (int)y1);
            }
        }
        g.setColor(oldC);
    }

}
