package gameObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelParser {

    private static char[][][][] levels;
    private static ArrayList<String> fileNameList = new ArrayList<>();
    final private static char FLOOR = ' ';
    final private static File levelDirectory = new File("src/levels/");

    private LevelParser() {
    }

    public static void initialize() throws CharacterException, FileNotFoundException{
        levels = parseAll();
    }

    //region getters
    public static ArrayList<String> getFileNameList() {
        return new ArrayList<>(fileNameList);
    }

    static String getFileName(int fileNumber) throws IndexOutOfBoundsException {
        return fileNameList.get(fileNumber);
    }

    public static int getNumberOfLevels(int fileNumber) throws IndexOutOfBoundsException {
        return levels[fileNumber].length;
    }

    public static int getNumberOfFiles() {
        return levels.length;
    }

    static char[][] getLevel(int fileNumber, int levelNumber) throws IndexOutOfBoundsException {
        return levels[fileNumber][levelNumber].clone();
    }
    //endregion

    //region parsing methods
    //read and  parse all files
    private static char[][][][] parseAll() throws FileNotFoundException, CharacterException, NullPointerException {
        char[][][][] levelArray;
        ArrayList<ArrayList<String>> fileLineList = new ArrayList<>();
        if (levelDirectory.exists()) {
            for (File file : levelDirectory.listFiles()) {
                if (file.getName().matches(".*\\.txt")) {
                    fileLineList.add(readLinesInFile(file));
                    fileNameList.add(file.getName());
                }
            }
        }
        levelArray = new char[fileLineList.size()][][][];
        for (int nFile = 0; nFile < fileLineList.size(); nFile++) {
            ArrayList<ArrayList<String>> levels =
                    splitFileIntoLevels(fileLineList.get(nFile), fileNameList.get(nFile));
            levelArray[nFile] = new char[levels.size()][][];
            for (int nLevel = 0; nLevel < levels.size(); nLevel++) {
                levelArray[nFile][nLevel] = convertLevelToArray(levels.get(nLevel));
            }
        }
        return levelArray;
    }

    //read all the lines from one file
    private static ArrayList<String> readLinesInFile(File file) throws FileNotFoundException {
        ArrayList<String> fileLines = new ArrayList<>();
        if (file.getName().matches(".*.txt")) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                fileLines.add(scanner.nextLine());
            }
        }
        return fileLines;
    }

    //split one file into its levels
    private static ArrayList<ArrayList<String>> splitFileIntoLevels(ArrayList<String> fileLines, String fileName)
            throws CharacterException {
        ArrayList<ArrayList<String>> levelList = new ArrayList<>();
        ArrayList<String> levelLines = new ArrayList<>();
        int levelNumber = 0;
        for (String line : fileLines) {
            if (line.isBlank()) {
                continue;
            }
            levelNumber++;
            //if there is no semicolon
            if (!line.matches("\\s;.*")) {
                if (line.matches("[^@#$+*. ]")) {
                    String invalidChar = line.replaceAll("(.*)([^@#$+* ])(.*)", "$2");
                    throw new CharacterException(fileName, levelNumber, invalidChar);
                } else {
                    levelList.add(levelLines);
                }
                //if the level is finished
            } else {
                levelList.add(levelLines);
            }
        }
        return levelList;
    }

    //convert one level
    private static char[][] convertLevelToArray(ArrayList<String> levelLines) {
        int height = levelLines.size();
        int width = 0;
        for (String line : levelLines) {
            width = (width < line.length()) ? line.length() : width;
        }
        char[][] levelArray = new char[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col < levelLines.get(row).length()) {
                    levelArray[row][col] = levelLines.get(row).charAt(col);
                } else {
                    levelArray[row][col] = FLOOR;
                }
            }
        }
        return levelArray;
    }
    //endregion
}
