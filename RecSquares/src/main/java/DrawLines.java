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
public class DrawLines extends Panel {
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
        Panel p = new DrawLines();
        f.add(p);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        drawFigure(g, 20, 20, 100, 1);
    }

    private void drawFigure(Graphics g, int x, int y, int len, int level) {

        if (level >= 0) {
            len = len / 3;
            drawFigure(g, x, y, len, level - 1);
            drawFigure(g, x + len, y + len, len, level - 1);
            drawFigure(g, x + 2 * (len), y, len, level - 1);
        } else {
            g.drawLine(x, y, x + len, y);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i]; i++; k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j]; j++; k++;
        }
    }

}
