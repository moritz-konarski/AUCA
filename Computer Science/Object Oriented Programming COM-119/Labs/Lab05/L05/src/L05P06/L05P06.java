package L05P06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class L05P06 extends JFrame {

    final private static int WINDOW_HEIGHT = 500;
    final private static int WINDOW_WIDTH = 500;
    final private static String TITLE = "L05P06";

    private L05P06() {
        JPanel coloredPanel = new JPanel();
        coloredPanel.addMouseMotionListener(
                new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent mouseEvent) {
                    }

                    @Override
                    public void mouseMoved(MouseEvent mouseEvent) {
                        setTitle(String.format("%d, %d", mouseEvent.getX(), mouseEvent.getY()));
                    }
                }
        );

        coloredPanel.setEnabled(true);
        coloredPanel.setBackground(Color.GRAY);
        coloredPanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        setTitle(TITLE);
        setLayout(null);
        getContentPane().add(coloredPanel);
        getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new L05P06();
    }
}
