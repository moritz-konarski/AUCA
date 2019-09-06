package L05P01;

import javax.swing.*;
import java.awt.*;

class L05P01 extends JFrame {

    final private static int WIDTH_WINDOW = 500;
    final private static int HEIGHT_WINDOW = 500;
    final private static int WIDTH_BUTTON = 100;
    final private static int HEIGHT_BUTTON = 25;
    final private static int PADDING = 3;
    final private static String TITLE = "L05P01";
    final private static Color COLOR_BACKGROUND = Color.GRAY;

    private L05P01() {
        JPanel panel = new JPanel();
        JButton redButton = new JButton("RED");
        JButton blueButton = new JButton("BLUE");
        JButton greenButton = new JButton("GREEN");

        panel.setBounds(0, 0, WIDTH_WINDOW, HEIGHT_WINDOW - 2 * PADDING - HEIGHT_BUTTON);
        panel.setBackground(Color.RED);
        panel.setEnabled(true);

        int yHeight = HEIGHT_WINDOW - HEIGHT_BUTTON - PADDING;
        int xMiddle = WIDTH_WINDOW / 2;
        redButton.setBounds(xMiddle - 3 * WIDTH_BUTTON / 2 - PADDING, yHeight, WIDTH_BUTTON, HEIGHT_BUTTON);
        greenButton.setBounds(xMiddle - WIDTH_BUTTON / 2, yHeight, WIDTH_BUTTON, HEIGHT_BUTTON);
        blueButton.setBounds(xMiddle + WIDTH_BUTTON / 2 + PADDING, yHeight, WIDTH_BUTTON, HEIGHT_BUTTON);

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        getContentPane().add(redButton);
        getContentPane().add(greenButton);
        getContentPane().add(blueButton);
        getContentPane().setPreferredSize(new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW));
        getContentPane().setBackground(COLOR_BACKGROUND);
        setLayout(null);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new L05P01();
    }
}
