package second_version;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.JPanel;
import second_version.readers.Reader;

public class CanvasPanel extends JPanel {
//    todo: - rewrite logic to support rotating arrows
//          - add logic for measurement system, f.e. km, m, kg
//          - make numbers for X and Y appear in the middle and dynamically
//          - implement rectangles

    private ArrayList<Point> points = new ArrayList<>();

    public CanvasPanel() {}

    public CanvasPanel(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        paintCoordinates(graphics);

        for (Point point : points) {
            graphics.setStroke(new BasicStroke(5f));
            graphics.drawLine(point.x, point.y, point.x, point.y);
        }

    }

    void paintCoordinates(Graphics2D graphics) {

        drawArrow(graphics, 50, 50, this.getWidth() - 50, 50, 20);        // 0 => X
        drawArrow(graphics, 50, 50, 50, this.getHeight() - 50, 20);       // 0 => Y

    }

    void drawArrow(Graphics2D graphics, int x1, int y1, int x2, int y2, int intervals) {
        graphics.drawLine(x1, y1, x2, y2);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 7));
        if (x2 > x1) {
            // here we draw an arrow head
            graphics.fillPolygon(
                new int[] {x2, x2 + 5, x2,     x2,     x2 + 5},
                new int[] {y2, y2,     y2 + 5, y2 - 5, y2},
                5
            );
            for (int i = x1; i < x2; i += intervals) {
                graphics.drawLine(i, y1 + 2, i, y1 - 2);
                graphics.drawString("" + i, i, y1 - 6);
            }
        } else if (y2 > y1) {
            // here we draw an arrow head
            graphics.fillPolygon(
                new int[] {x2, x2,     x2 + 5, x2 - 5, x2},
                new int[] {y2, y2 + 5, y2,     y2,     y2 + 5},
                5
            );
            for (int i = y1 + intervals; i < y2; i += intervals) {
                graphics.drawLine(x1 + 2, i, x1 - 2, i);
                graphics.drawString("" + i, x1 - 20, i);
            }
        }

    }

    public void loadData(Reader reader) throws FileNotFoundException, URISyntaxException {
        ArrayList<Point> loadedList = reader.load();
        if (!this.points.isEmpty()) {
            this.points.addAll(loadedList);
        } else {
            this.points = loadedList;
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}