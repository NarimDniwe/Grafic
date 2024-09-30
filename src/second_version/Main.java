package second_version;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        CanvasPanel panel = new CanvasPanel();
        frame.add(panel);

    }
}

class CanvasPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

    }
}
