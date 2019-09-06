import gameObjects.CharacterException;
import gameObjects.LevelParser;
import graphicsObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Main extends JFrame {
    private int moveCounter;
    private static int windowWidth = 1300;
    private static int windowHeight = 800;
    final private static int BAR_HEIGHT = 40;
    final private static int BAR_WIDTH = 200;
    final private static int FONT_SIZE = 17;
    final private static Color BAR_COLOR = Color.LIGHT_GRAY;
    final private static String TITLE = "Sokoban";
    final private static Font FONT = new Font("Sans-Serif", Font.BOLD, FONT_SIZE);
    private static int selectedFile, selectedLevel;

    private GameScreen gameScreen;
    private TopBar topBar;
    private RightSideBar rightSideBar;
    private KeyInputListener kil;

    private Main() {
        selectedFile = selectedLevel = 0;
        moveCounter = 0;
        setTitle(TITLE);
        if (parseLevels()) {
            gameScreen = new GameScreen(windowWidth, windowHeight, BAR_WIDTH, BAR_HEIGHT, selectedFile, selectedLevel, this);
            topBar = new TopBar(windowWidth, BAR_HEIGHT, BAR_COLOR, FONT);
            rightSideBar = new RightSideBar(BAR_WIDTH, BAR_HEIGHT, windowHeight, BAR_COLOR, FONT);
            kil = new KeyInputListener(this);

            topBar.addComboBoxListener(e -> updateLevel(topBar.getSelectedIndex(), 0));
            rightSideBar.addNextLevelBtnListener(e -> updateLevel(selectedFile, ++selectedLevel));
            rightSideBar.addPreviousLevelBtnListener(e -> updateLevel(selectedFile, --selectedLevel));
            rightSideBar.addRedoListener(e -> redoMove());
            rightSideBar.addUndoListener(e -> undoMove());
            rightSideBar.addResetListener(e -> resetField());

            getContentPane().add(gameScreen);
            getContentPane().add(topBar, BorderLayout.NORTH);
            getContentPane().add(new BottomBar(windowWidth, BAR_HEIGHT, BAR_COLOR, FONT), BorderLayout.SOUTH);
            getContentPane().add(rightSideBar, BorderLayout.LINE_END);

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    windowHeight = e.getComponent().getHeight();
                    windowWidth = e.getComponent().getWidth();
                }
            });
            addKeyListener(kil);
            gameScreen.addKeyAdapter(kil);
            updateLevel(selectedFile, selectedLevel);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setLocationRelativeTo(null);
            setFocusable(true);
            setVisible(true);
        } else {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    private void updateLevel(int selectedFile, int selectedLevel) {
        moveCounter = 0;
        gameScreen.update(selectedFile, selectedLevel);
        rightSideBar.updateLevelLabel(gameScreen.getSelectedLevel(), gameScreen.getNumberOfLevels());
        rightSideBar.updateMoveLabel(moveCounter);
        Main.selectedFile = gameScreen.getSelectedFile();
        Main.selectedLevel = gameScreen.getSelectedLevel();
    }

    private boolean parseLevels() {
        try {
            LevelParser.initialize();
            return true;
        } catch (IndexOutOfBoundsException | FileNotFoundException | NullPointerException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "An error occurred!", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (CharacterException e) {
            System.out.println(e.getMessage());
            System.out.println("Level " + e.getLevelNumber() + " in file " + e.getFileName());
            e.getLevel().forEach(System.out::println);
            StringBuilder message = new StringBuilder();
            for (String s : e.getLevel()) {
                message.append(s).append("\n");
            }
            JOptionPane.showMessageDialog(this, message, e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void celebrateVictory() {
        JOptionPane.showMessageDialog(this, String.format("You solved level %d in %d moves", selectedLevel + 1, moveCounter),
                "Congratulations!", JOptionPane.PLAIN_MESSAGE);
        requestFocus();
        updateLevel(selectedFile, ++selectedLevel);
    }

    class KeyInputListener extends KeyAdapter {
        private Main main;
        KeyInputListener(Main main) {
            this.main = main;
        }
        @Override
        public void keyPressed(KeyEvent e) {
            boolean moved = false;
            int dx = 0, dy = 0;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:      //left arrow
                    if (e.isAltDown()) {
                        updateLevel(selectedFile, --selectedLevel);
                    } else if (e.isControlDown()) {
                        undoMove();
                    } else {
                        moved = true;
                        dx = -1;
                    }
                    break;
                case KeyEvent.VK_RIGHT:     //left arrow
                    if (e.isAltDown()) {
                        updateLevel(selectedFile, ++selectedLevel);
                    } else if (e.isControlDown()) {
                        redoMove();
                    } else {
                        moved = true;
                        dx = 1;
                    }
                    break;
                case KeyEvent.VK_DOWN:      //left arrow
                    moved = true;
                    dy = 1;
                    break;
                case KeyEvent.VK_UP:        //left arrow
                    moved = true;
                    dy = -1;
                    break;
                case KeyEvent.VK_ESCAPE:    //reset level
                    resetField();
                    break;
            }
            if (moved) {
                gameScreen.getPlayer().setDy(dy);
                gameScreen.getPlayer().setDx(dx);
                if (!gameScreen.hasPlayerCollision(dx, dy)) {
                    gameScreen.getPlayer().move(dx, dy);
                    gameScreen.setPlayerPosition(dx, dy);
                    gameScreen.moveRemainingObjects(++moveCounter);
                } else if (gameScreen.isMoveableCrate(dx, dy)) {
                    gameScreen.setCratePosition(dx, dy);
                    gameScreen.getPlayer().move(dx, dy);
                    gameScreen.setPlayerPosition(dx, dy);
                    gameScreen.moveRemainingObjects(++moveCounter);
                }
                if (gameScreen.gameWon()){
                    main.celebrateVictory();
                }
            }
            gameScreen.repaint();
            rightSideBar.updateMoveLabel(moveCounter);
        }
    }

    private void undoMove() {
        if (moveCounter > 0) {
            gameScreen.undoMove();
            rightSideBar.updateMoveLabel(--moveCounter);
        }
    }

    private void redoMove() {
        if (moveCounter < gameScreen.getPlayer().getMoveCount()) {
            gameScreen.redoMove();
            rightSideBar.updateMoveLabel(++moveCounter);
        }
    }

    private void resetField() {
        gameScreen.reset();
        moveCounter = 0;
        rightSideBar.updateMoveLabel(moveCounter);
    }
}

