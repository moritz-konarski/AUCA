package panelObjects;

import gameObjects.LevelParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopBar extends JPanel {
    private JComboBox fileNameBox;

    public TopBar(int width, int height, Color color, Font font) {
        setBackground(color);
        setPreferredSize(new Dimension(width, height));
        String[] names = new String[LevelParser.getNumberOfFiles()];
        for (int i = 0; i < names.length; i++) {
            names[i] = LevelParser.getFileNameList().get(i);
        }
        fileNameBox = new JComboBox(names);
        fileNameBox.setSelectedIndex(0);
        fileNameBox.setFont(font);
        add(fileNameBox);
        setVisible(true);
    }

    public void addComboBoxListener(ActionListener l) {
        fileNameBox.addActionListener(l);
    }

    public int getSelectedIndex() {
        return fileNameBox.getSelectedIndex();
    }
}

