import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * Created on Nov 16, 2013
 */

/**
 * @author Wolfgang Weck
 */
public class RecSquares2 extends Panel {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final Frame f = new Frame();
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                f.repaint();
            }
        });
        f.setSize(410, 450);
        Panel p = new RecSquares2();
        f.add(p);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        int w = getWidth() / 2, h = getHeight() / 2;
        int top = h / 2, left = w / 2;
        drawSquares(g, left, top, (Math.min(w, h)) - 4);
    }

    private void drawSquares(Graphics g, int left, int top, int size) {
        if (size >= 16) {

            g.setColor(Color.orange);
            g.fillRect(left, top, size, size);
            g.setColor(Color.black);
            g.drawRect(left, top, size, size);

            int s = size / 2;
            drawSquares(g, left - s / 2, top - s / 2, s); // oben links
            drawSquares(g, left + size - s / 2, top - s / 2, s); // oben rechts
            drawSquares(g, left + size - s / 2, top + size - s / 2, s); // unten rechts
            drawSquares(g, left - s / 2, top + size - s / 2, s); // unten links
        }
    }
}
