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
public class RecCircles extends Panel {
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
        Panel p = new RecCircles();
        f.add(p);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        int w = getWidth(), h = getHeight();
        int top = 2, left = 2;
        drawCircles(g, left, top, (Math.min(w, h)) - 4);
    }

    private static final int margin = 2;

    private void drawCircles(Graphics g, int left, int top, int size) {
        if (size >= 8) {
            g.drawOval(left, top, size, size);
            int s = size / 2;
            drawCircles(g, left, top + s/2, s); //  links
            drawCircles(g, left + s, top + s/2, s); //  rechts
        }
    }
}
