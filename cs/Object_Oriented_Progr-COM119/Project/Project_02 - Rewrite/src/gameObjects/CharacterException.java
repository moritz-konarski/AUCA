package gameObjects;

public class CharacterException extends Exception {
    private static final String message = "Invalid character %s in file %s level %d!";
    private static final String reason = "Invalid character in file";
    private int levelNumber;
    private String fileName;
    private String invalidChar;

    CharacterException(String fileName, int levelNumber, String invalidChar) {
        this.fileName = fileName;
        this.levelNumber = levelNumber;
        this.invalidChar = invalidChar;
    }

    @Override
    public String getMessage() {
        return String.format(message, invalidChar, fileName, levelNumber);
    }

    public String getReason() {
        return reason;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String getFileName() {
        return fileName;
    }
}