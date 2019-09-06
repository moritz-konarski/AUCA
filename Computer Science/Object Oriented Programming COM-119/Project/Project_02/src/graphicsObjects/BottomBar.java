package graphicsObjects;

import javax.swing.*;
import java.awt.*;

public class BottomBar extends JPanel {

    public BottomBar(int windowWidth, int barHeight, Color color, Font font) {
        setBackground(color);
        setLayout(new GridLayout(1, 5));
        JLabel label = new JLabel("Esc: Restart", JLabel.CENTER);
        label.setFont(font);
        add(label);
        label = new JLabel("Ctrl+Left: Undo", JLabel.CENTER);
        label.setFont(font);
        add(label);
        label = new JLabel("Ctrl+Right: Redo", JLabel.CENTER);
        label.setFont(font);
        add(label);
        label = new JLabel("Alt+Left: Previous", JLabel.CENTER);
        label.setFont(font);
        add(label);
        label = new JLabel("Alt+Right: Next", JLabel.CENTER);
        label.setFont(font);
        add(label);
        setPreferredSize(new Dimension(windowWidth, barHeight));
        setVisible(true);
    }
}
