package L05P02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonActionListener implements ActionListener {

    private Color color;
    private JPanel panel;

    ButtonActionListener(JPanel panel, Color color) {
        this.panel = panel;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setBackground(color);
    }
}
