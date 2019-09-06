package L05P05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class L05P05 extends JFrame {

    final private static int WINDOW_HEIGHT = 500;
    final private static int WINDOW_WIDTH = 500;
    final private static String TITLE = "L05P05";
    final private static Color BACKGROUND_COLOR = Color.GRAY;

    private L05P05() {
        JPanel coloredPanel = new JPanel();
        PanelMouseMotionListener ml = new PanelMouseMotionListener(this);

        coloredPanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        coloredPanel.setBackground(BACKGROUND_COLOR);
        coloredPanel.setEnabled(true);
        coloredPanel.addMouseMotionListener(ml);

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(coloredPanel);
        getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLayout(null);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new L05P05();
    }

    static class PanelMouseMotionListener implements MouseMotionListener {

        private JFrame frame;

        PanelMouseMotionListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            frame.setTitle(String.format("%d, %d", e.getX(), e.getY()));
        }
    }
}
