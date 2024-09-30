package second_version;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        CanvasPanel panel = new CanvasPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}

class CanvasPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
        paintCoordinates(graphics);

    }

    void paintCoordinates(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        drawArrow(graphics, 50, 50, this.getWidth() - 50, 50, 20);        // 0 => X
        drawArrow(graphics, 50, 50, 50, this.getHeight() - 50, 20);       // 0 => Y

    }

    void drawArrow(Graphics2D graphics, int x1, int y1, int x2, int y2, int intervals) {
        graphics.drawLine(x1, y1, x2, y2);
        // temp solution
        // todo: - rewrite logic to support rotating arrows
        if (x2 > x1) {
            // here we draw an arrow head
            graphics.fillPolygon(
                new int[] {x2, x2 + 5, x2,     x2,     x2 + 5},
                new int[] {y2, y2,     y2 + 5, y2 - 5, y2},
                5
            );
            for (int i = x1; i < x2; i += intervals) {
                graphics.drawLine(i, y1 + 2, i, y1 - 2);
            }
        } else if (y2 > y1) {
            // here we draw an arrow head
            graphics.fillPolygon(
                new int[] {x2, x2,     x2 + 5, x2 - 5, x2},
                new int[] {y2, y2 + 5, y2,     y2,     y2 + 5},
                5
            );
            for (int i = y1; i < y2; i += intervals) {
                graphics.drawLine(x1 + 2, i, x1 - 2, i);
            }
        }

    }
}
