package L05P08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class L05P08 extends JPanel {

    final private static String TITLE = "L05P08 - Chessboard";
    private static int width = 500;
    private static int height = 500;
    final private static int SQUARES_PER_SIDE = 8;

    @Override
    public void paint(Graphics g) {
        double squareHeight = 1.0 * height / SQUARES_PER_SIDE;
        double squareWidth = 1.0 * width / SQUARES_PER_SIDE;
        for (int row = 0; row < SQUARES_PER_SIDE; row++) {
            for (int col = 0; col < SQUARES_PER_SIDE; col++) {
                g.setColor((row + col) % 2 == 0 ? Color.WHITE : Color.BLACK);
                g.fillRect((int) (row * squareWidth), (int) (col * squareHeight), (int) squareWidth, (int) squareHeight);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(TITLE);
        frame.addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        height = frame.getContentPane().getHeight();
                        width = frame.getContentPane().getWidth();
                    }
                });
        frame.add(new L05P08());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
