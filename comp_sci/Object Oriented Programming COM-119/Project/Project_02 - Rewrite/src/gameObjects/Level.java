package gameObjects;

import gameObjects.Interfaces.Collision;
import gameObjects.Interfaces.Moveable;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Level {

    private Player player;
    private SokobanObject[][][] level;
    private ArrayList<Collision> collisionObjects;
    final private static char PLAYER = '@';
    final private static char PLAYER_ON_STORAGE = '+';
    final private static char WALL = '#';
    final private static char FLOOR = ' ';
    final private static char CRATE = '$';
    final private static char CRATE_IN_STORAGE = '*';
    final private static char STORAGE = '.';

    private Level(SokobanObject[][][] level) {
        this.level = level;
    }

    public static Level parseLevel(int fileNumber, int levelNumber) throws InputMismatchException {
        char[][] data = LevelParser.getLevel(fileNumber, levelNumber);
        System.out.println(data.length);
        System.out.println(data[0].length);
        SokobanObject[][][] level = new SokobanObject[2][data.length][data[0].length];
        int playerCount = 0, crateCount = 0, storageCount = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                switch (data[row][col]) {
                    case PLAYER:
                        level[1][row][col] = new Player(col, row);
                        level[0][row][col] = new Floor(false);
                        playerCount++;
                        break;
                    case PLAYER_ON_STORAGE:
                        level[1][row][col] = new Player(col, row);
                        level[0][row][col] = new Floor(true);
                        playerCount++;
                        storageCount++;
                        break;
                    case FLOOR:
                        level[0][row][col] = new Floor(false);
                        break;
                    case CRATE:
                        level[1][row][col] = new Crate(col, row, false);
                        level[0][row][col] = new Floor(false);
                        crateCount++;
                        break;
                    case CRATE_IN_STORAGE:
                        level[1][row][col] = new Crate(col, row, true);
                        level[0][row][col] = new Floor(true);
                        crateCount++;
                        storageCount++;
                        break;
                    case STORAGE:
                        level[0][row][col] = new Floor(true);
                        storageCount++;
                        break;
                    case WALL:
                        level[1][row][col] = new Wall();
                        level[0][row][col] = new Floor(false);
                        break;
                }
            }
        }
        if (crateCount != storageCount || playerCount != 1) {
            throw new InputMismatchException(
                    String.format("Invalid numbers of objects in file %s level %d",
                            LevelParser.getFileName(fileNumber), levelNumber));
        }
//        remove floor from outside the walls
        for (int row = 0; row < level[0].length; row++) {
            for (int col = 0; col < level[0][0].length && !(level[1][row][col] instanceof Wall); col++) {
                level[0][row][col] = new SokobanObject(SokobanObject.ObjectType.EMPTY);
            }
            for (int col = level[0][0].length - 1; col >= 0 && !(level[1][row][col] instanceof Wall); col--) {
                level[0][row][col] = new SokobanObject(SokobanObject.ObjectType.EMPTY);
            }
        }
        for (int col = 0; col < level[0][0].length; col++) {
            for (int row = 0; row < level[0].length && !(level[1][row][col] instanceof Wall); row++) {
                level[0][row][col] = new SokobanObject(SokobanObject.ObjectType.EMPTY);
            }
            for (int row = level[0].length - 1; row >= 0 && !(level[1][row][col] instanceof Wall); row--) {
                level[0][row][col] = new SokobanObject(SokobanObject.ObjectType.EMPTY);
            }
        }
        return new Level(level);
    }

    public ArrayList<Collision> getCollisionObjects() {
        return collisionObjects;
    }

    public SokobanObject[][][] getLevelArray() {
        return level;
    }

    public void prepareArrayLists() {
        collisionObjects = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (SokobanObject[] row : level[i]) {
                for (SokobanObject field : row) {
                    if (field instanceof Moveable) {
                        collisionObjects.add((Collision) field);
                    }
                    if (i == 1 && field instanceof Player) {
                        this.player = (Player) field;
                    }
                }
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getNColumns() {
        return level[0][0].length;
    }

    public int getNRows() {
        return level[0].length;
    }
}
