package L05P07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class L05P07 extends JFrame {

    final private static int WINDOW_HEIGHT = 500;
    final private static int WINDOW_WIDTH = 500;
    final private static String TITLE = "L05P07";

    private L05P07() {
        JPanel coloredPanel = new JPanel();
        coloredPanel.addMouseMotionListener(
                new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent mouseEvent) {
                        setTitle(String.format("%d, %d", mouseEvent.getX(), mouseEvent.getY()));
                    }
                }
        );

        coloredPanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        coloredPanel.setBackground(Color.GRAY);
        coloredPanel.setEnabled(true);

        setTitle(TITLE);
        add(coloredPanel);
        getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new L05P07();
    }
}
