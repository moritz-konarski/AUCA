package L05P09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class L05P09 extends JFrame {

    final private static String TITLE = "L05P09 - Chessboard with Dot";
    final private static int SQUARES_PER_SIDE = 8;
    private static int width = 500;
    private static int height = 500;

    private L05P09() {
        Board b = new Board(SQUARES_PER_SIDE);
        add(b);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(width, height));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new L05P09();
    }
}

class Board extends JPanel {
    private int nSquares, ballX, ballY;
    private int height, width;

    Board(int nSquares) {
        this.nSquares = nSquares;
        addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        height = getHeight();
                        width = getWidth();
                    }
                });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight();
                        break;
                    case KeyEvent.VK_UP:
                        moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        moveDown();
                        break;
                }
                repaint();
            }
        });
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        double squareHeight = 1.0 * height / nSquares;
        double squareWidth = 1.0 * width / nSquares;
        for (int row = 0; row < nSquares; row++) {
            for (int col = 0; col < nSquares; col++) {
                g.setColor((row + col) % 2 == 0 ? Color.WHITE : Color.BLACK);
                g.fillRect((int) (row * squareWidth), (int) (col * squareHeight), (int) squareWidth, (int) squareHeight);
            }
        }
        g.setColor(Color.RED);
        g.fillOval((int) (ballX * squareWidth), (int) (ballY * squareHeight), (int) squareWidth, (int) squareHeight);
    }

    private void moveDown() {
        if (ballY < nSquares - 1) {
            ballY++;
        }
    }

    private void moveUp() {
        if (ballY > 0) {
            ballY--;
        }
    }

    private void moveRight() {
        if (ballX < nSquares - 1) {
            ballX++;
        }
    }

    private void moveLeft() {
        if (ballX > 0) {
            ballX--;
        }
    }
}