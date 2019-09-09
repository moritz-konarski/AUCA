package graphicsObjects;

import gameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    private JFrame main;
    private int selectedLevel, selectedFile;
    private int width, height, xOffset, yOffset;
    private int squareSideLength;
    private Level level;
    private Player player;
    private static SokobanObject[][][] levelArray;
    private ArrayList<Collision> collisionObjects;
    final private static int STD_IMG_SIZE = 64;
    final private static int STORAGE_IMG_SIZE = 32;
    final private static int PLAYER_IMG_SIZE_HEIGHT = 59;
    final private static int PLAYER_IMG_SIZE_FRONT_WIDTH = 37;
    final private static int PLAYER_IMG_SIZE_SIDE_WIDTH = 42;
    private static int barWidth, barHeight;
    final private static Color GAME_BACKGROUND_COLOR = Color.BLACK;

    public GameScreen(int width, int height, int barWidth, int barHeight, int selectedFile, int selectedLevel, JFrame main) {
        this.selectedLevel = selectedLevel;
        this.selectedFile = selectedFile;
        this.main = main;
        GameScreen.barHeight = barHeight;
        GameScreen.barWidth = barWidth;
        setBackground(GAME_BACKGROUND_COLOR);
        width = width - barWidth;
        height = height - 2 * barHeight;
        update(selectedFile, selectedLevel);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        updateDimensions();
        g.setColor(Color.black);
        g.fillRect(0, 0, this.width, this.height);
        SokobanObject object;
        int layer = 0;
        int x = 0, y = 0;
        for (int row = 0; row < level.getNRows(); row++) {
            for (int col = 0; col < level.getNColumns(); col++) {
                object = levelArray[layer][row][col];
                if (object instanceof Floor) {
                    x = xOffset + squareSideLength * col;
                    y = yOffset + squareSideLength * row;
                    g.drawImage(object.getImage(), x, y, x + squareSideLength, y + squareSideLength,
                            0, 0, STD_IMG_SIZE, STD_IMG_SIZE, null);
                    if (((Floor) object).isStorageLocation()) {
                        g.drawImage(((Floor) object).getStorageLocationImage(), x + squareSideLength / 4,
                                y + squareSideLength / 4, x + 3 * squareSideLength / 4,
                                y + 3 * squareSideLength / 4, 0, 0, STORAGE_IMG_SIZE,
                                STORAGE_IMG_SIZE, null);
                    }
                }
            }
        }
        layer = 1;
        for (int row = 0; row < level.getNRows(); row++) {
            for (int col = 0; col < level.getNColumns(); col++) {
                object = levelArray[layer][row][col];
                if (object instanceof Collision) {
                    x = xOffset + squareSideLength * col;
                    y = yOffset + squareSideLength * row;
                    if (object instanceof Wall) {
                        g.drawImage(object.getImage(), x, y, x + squareSideLength, y + squareSideLength,
                                0, 0, STD_IMG_SIZE, STD_IMG_SIZE, null);
                    } else if (object instanceof Crate) {
                        if (((Crate) object).isInStorage()) {
                            g.drawImage(((Crate) object).getStorageImage(), x, y, x + squareSideLength, y + squareSideLength,
                                    0, 0, STD_IMG_SIZE, STD_IMG_SIZE, null);
                        } else {
                            g.drawImage(object.getImage(), x, y, x + squareSideLength, y + squareSideLength,
                                    0, 0, STD_IMG_SIZE, STD_IMG_SIZE, null);
                        }
                    } else if (object instanceof Player) {
                        int dx = ((Player) object).getDx();
                        int dy = ((Player) object).getDy();
                        if (dy == 1) { //down
                            g.drawImage(object.getImage(), x, y, x + squareSideLength, y + squareSideLength,
                                    0, 0, PLAYER_IMG_SIZE_FRONT_WIDTH, PLAYER_IMG_SIZE_HEIGHT, null);
                        } else if (dy == -1) {
                            g.drawImage(((Player) object).getBackImage(), x, y, x + squareSideLength, y + squareSideLength,
                                    0, 0, PLAYER_IMG_SIZE_FRONT_WIDTH, PLAYER_IMG_SIZE_HEIGHT, null);
                        } else if (dx == 1) {
                            g.drawImage(((Player) object).getRightImage(), x, y, x + squareSideLength, y + squareSideLength,
                                    0, 0, PLAYER_IMG_SIZE_SIDE_WIDTH, PLAYER_IMG_SIZE_HEIGHT, null);

                        } else if (dx == -1) {
                            g.drawImage(((Player) object).getLeftImage(), x, y, x + squareSideLength, y + squareSideLength,
                                    0, 0, PLAYER_IMG_SIZE_SIDE_WIDTH, PLAYER_IMG_SIZE_HEIGHT, null);
                        }
                    }
                }
            }
        }
    }

    private void updateDimensions() {
        width = main.getWidth() - barWidth;
        height = main.getHeight() - 2 * barHeight;
        if (height < width) {
            squareSideLength = (int) ((0.8 * height) / level.getNRows());
        } else {
            squareSideLength = (int) ((0.8 * width) / level.getNColumns());
        }
        xOffset = (width - level.getNColumns() * squareSideLength) / 2;
        yOffset = (height - level.getNRows() * squareSideLength) / 2;
        if (xOffset < 0.05 * width) {
            squareSideLength = (int) ((0.8 * width) / level.getNColumns());
        } else if (yOffset < 0.05 * height) {
            squareSideLength = (int) ((0.8 * height) / level.getNRows());
        }
        xOffset = (width - level.getNColumns() * squareSideLength) / 2;
        yOffset = (height - level.getNRows() * squareSideLength) / 2;
    }

    public void update(int selectedFile, int selectedLevel) {
        if (selectedFile < LevelParser.getNumberOfFiles() && selectedLevel < LevelParser.getNumberOfLevels(selectedFile)
                && selectedFile >= 0 && selectedLevel >= 0) {
            this.selectedFile = selectedFile;
            this.selectedLevel = selectedLevel;
            level = Level.parseLevel(selectedFile, selectedLevel);
            level.prepareArrayLists();
            player = level.getPlayer();
            levelArray = level.getLevelArray();
            collisionObjects = level.getCollisionObjects();
            repaint();
        }
        requestFocus();
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }

    public int getSelectedFile() {
        return selectedFile;
    }

    public int getNumberOfLevels() {
        return LevelParser.getNumberOfLevels(selectedFile);
    }

    public Player getPlayer() {
        repaint();
        return level.getPlayer();
    }

    public void setPlayerPosition(int dx, int dy) {
        levelArray[1][player.getY()][player.getX()] = getPlayer();
        levelArray[1][player.getY() - dy][player.getX() - dx] = null;

        repaint();
    }

    public void setCratePosition(int dx, int dy) {
        levelArray[1][player.getY() + 2 * dy][player.getX() + 2 * dx] = levelArray[1][player.getY() + dy][player.getX() + dx];
        levelArray[1][player.getY() + dy][player.getX() + dx] = null;
        ((Crate) levelArray[1][player.getY() + 2 * dy][player.getX() + 2 * dx]).move(dx, dy);
        if (((Floor) levelArray[0][player.getY() + 2 * dy][player.getX() + 2 * dx]).isStorageLocation()) {
            ((Crate) levelArray[1][player.getY() + 2 * dy][player.getX() + 2 * dx]).setInStorage(true);
        } else {
            ((Crate) levelArray[1][player.getY() + 2 * dy][player.getX() + 2 * dx]).setInStorage(false);
        }
        repaint();
    }

    public boolean gameWon() {
        int count = 0, crateCount = 0;
        for (Collision c : collisionObjects) {
            if (c instanceof Crate) {
                crateCount++;
                if (((Crate) c).isInStorage()) {
                    count++;
                }
            }
        }
        return count == crateCount;
    }

    public void moveRemainingObjects(int moveCounter) {
        for (Collision c : collisionObjects) {
            if (c instanceof Crate && ((Crate) c).getMoveCount() < moveCounter) {
//                System.out.println("C: " + ((Crate) c).getMoveCount());
                ((Crate) c).move(0, 0);
//                System.out.println("C: " + ((Crate) c).getMoveCount());
            }
        }
    }

    public boolean hasPlayerCollision(int dx, int dy) {
        return levelArray[1][player.getY() + dy][player.getX() + dx] instanceof Collision;
    }

    public boolean isMoveableCrate(int dx, int dy) {
        return levelArray[1][player.getY() + dy][player.getX() + dx] instanceof Crate &&
                !(levelArray[1][player.getY() + 2 * dy][player.getX() + 2 * dx] instanceof Collision);
    }

    public void addKeyAdapter(KeyAdapter keyAdapter) {
        this.addKeyListener(keyAdapter);
    }

    public void undoMove() {
        for (Collision c : collisionObjects) {
            if (c instanceof MoveableSokobanObject) {
                ((MoveableSokobanObject) c).undoMove();
//                System.out.print(((MoveableSokobanObject) c).getMoveCount() + " " +((MoveableSokobanObject) c).getCurrentMove() + " ");
//                System.out.println(c instanceof Crate);
            }
        }
//        System.out.println("----------");
        updateArrayByArrayList();
        repaint();
        requestFocus();
    }

    public void redoMove() {
        for (Collision c : collisionObjects) {
            if (c instanceof MoveableSokobanObject) {
                ((MoveableSokobanObject) c).redoMove();
//                System.out.print(((MoveableSokobanObject) c).getMoveCount() + " " +((MoveableSokobanObject) c).getCurrentMove() + " ");
//                System.out.println(c instanceof Crate);
            }
        }
//        System.out.println("----------");
        updateArrayByArrayList();
        repaint();
        requestFocus();
    }

    public void reset() {
        update(selectedFile, selectedLevel);
        requestFocus();
        repaint();
    }

    private void updateArrayByArrayList() {
        for (int row = 0; row < levelArray[0].length; row++) {
            for (int col = 0; col < levelArray[0][0].length; col++) {
                if (!(levelArray[1][row][col] instanceof Wall)) {
                    levelArray[1][row][col] = null;
                }
            }
        }
        for (Collision c : collisionObjects) {
            if (!(c instanceof Wall)) {
                Moveable temp = (Moveable) c;
                levelArray[1][temp.getY()][temp.getX()] = (SokobanObject) c;
                if (c instanceof Crate) {
                    if (((Floor) levelArray[0][((Crate) c).getY()][((Crate) c).getX()]).isStorageLocation()) {
                        ((Crate) c).setInStorage(true);
                    } else {
                        ((Crate) c).setInStorage(false);
                    }
                }
            }
        }
    }
}
