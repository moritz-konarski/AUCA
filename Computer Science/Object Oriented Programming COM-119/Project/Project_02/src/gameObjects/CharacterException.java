package gameObjects;

import java.util.ArrayList;

public class CharacterException extends Exception {
    private String message, fileName;
    private int levelNumber;
    private ArrayList<String> level;

    CharacterException(String message, String fileName, int levelNumber, ArrayList<String> level) {
        this.message = message;
        this.levelNumber = levelNumber;
        this.fileName = fileName;
        this.level = new ArrayList<>(level);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<String> getLevel() {
        return new ArrayList<>(level);
    }
}