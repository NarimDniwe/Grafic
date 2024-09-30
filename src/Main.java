import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        class TestPaint extends JPanel{
            @Override
           protected void paintComponent(Graphics g){
               super.paintComponent(g);
               g.setColor(Color.BLACK);

               g.drawLine(20,250,270,250); //линия X
               g.drawLine(20,250,20,20);   //линия Y

                int[] xPoints = {270, 270 - 10, 270 - 10}; //стрелка X
                int[] yPoints = {250, 250 - 5, 250 + 5};
               g.fillPolygon(xPoints, yPoints,3);

                int[] xPoints2 = {20, 20 - 5, 20 + 5};  //стрелка Y
                int[] yPoints2 = {20, 20 + 10, 20 + 10};
                g.fillPolygon(xPoints2, yPoints2,3);

                g.drawLine(50,253,50,250);  //чёрточки на координатах X
                g.drawLine(100,253,100,250);
                g.drawLine(150,253,150,250);
                g.drawLine(200,253,200,250);

                g.drawLine(16,225,23,225); //чёрточки на координатах Y
                g.drawLine(16,200,23,200);
                g.drawLine(16,175,23,175);
                g.drawLine(16,150,23,150);
                g.drawLine(16,125,23,125);
                g.drawLine(16,100,23,100);
                g.drawLine(16,75,23,75);
                g.drawLine(16,50,23,50);

                Graphics2D g2d = (Graphics2D) g;
                BasicStroke thinStroke = new BasicStroke(0.5f);
                g2d.setStroke(thinStroke);
                g2d.setPaint(Color.LIGHT_GRAY);
                g2d.drawLine(24,225, 220, 225); //серые линии
                g2d.drawLine(24,200, 220, 200);
                g2d.drawLine(24,175, 220, 175);
                g2d.drawLine(24,150, 220, 150);
                g2d.drawLine(24,125, 220, 125);
                g2d.drawLine(24,100, 220, 100);
                g2d.drawLine(24,75, 220, 75);
                g2d.drawLine(24,50, 220, 50);

                g.setColor(Color.RED);
                g.fillRect(37,150,25,100);
                g.setColor(Color.GREEN);
                g.fillRect(87, 200, 25, 50);
                g.setColor(Color.BLUE);
                g.fillRect(137, 175, 25, 75);
                g.setColor(Color.YELLOW);
                g.fillRect(187, 225, 25, 25);

                g2d.setColor(Color.BLACK);
                g2d.draw3DRect(37,150,25,100, false);
                g2d.draw3DRect(87, 200, 25, 50, false);
                g2d.draw3DRect(137, 175, 25, 75, false);
                g2d.draw3DRect(187, 225, 25, 25, false);


           }
        }


        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        TestPaint panel = new TestPaint();
        frame.add(panel);


    }
}
