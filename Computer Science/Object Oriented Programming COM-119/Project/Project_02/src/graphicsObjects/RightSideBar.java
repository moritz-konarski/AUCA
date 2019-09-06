package graphicsObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RightSideBar extends JPanel {
    private JLabel level, nMoves;
    private JButton nextLevel, previousLevel, reset, undo, redo;

    public RightSideBar(int barWidth, int barHeight, int windowHeight, Color color, Font font) {
        setLayout(new GridLayout(12, 1, 3, 3));
        setPreferredSize(new Dimension(barWidth, windowHeight - 2 * barHeight));
        setBackground(color);

        level = new JLabel("Level", JLabel.CENTER);
        level.setFont(font);
        nextLevel = new JButton(">>");
        nextLevel.setFont(font);
        previousLevel = new JButton("<<");
        previousLevel.setFont(font);
        nMoves = new JLabel("0 moves", JLabel.CENTER);
        nMoves.setFont(font);
        reset = new JButton("Reset");
        reset.setFont(font);
        undo = new JButton("Undo");
        undo.setFont(font);
        redo = new JButton("Redo");
        redo.setFont(font);

        add(level);
        add(nextLevel);
        add(previousLevel);
        add(nMoves);
        add(reset);
        add(undo);
        add(redo);

        setVisible(true);
    }

    public void addNextLevelBtnListener(ActionListener l) {
        nextLevel.addActionListener(l);
    }

    public void addPreviousLevelBtnListener(ActionListener l) {
        previousLevel.addActionListener(l);
    }

    public void updateLevelLabel(int currLevel, int maxLevel) {
        level.setText(String.format("Level %d of %d", currLevel + 1, maxLevel));
    }

    public void updateMoveLabel(int moveCount) {
        nMoves.setText(String.format("%d moves", moveCount));
    }

    public void addUndoListener(ActionListener l) {
        undo.addActionListener(l);
    }

    public void addRedoListener(ActionListener l) {
        redo.addActionListener(l);
    }

    public void addResetListener(ActionListener l) {
        reset.addActionListener(l);
    }
}

