package gameObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelParser {

    private static Scanner scanner;
    private static char[][][][] levels;
    private static ArrayList<String> fileNameList = new ArrayList<>();
    final private static char FLOOR = ' ';
    final private static File levelDirectory = new File("src/levels/");

    private LevelParser() {
    }

    public static void initialize() throws NullPointerException, FileNotFoundException, CharacterException {
        levels = parseLevels(readFiles());
    }

    public static ArrayList<String> getFileNameList() {
        return new ArrayList<>(fileNameList);
    }

    public static int getNumberOfLevels(int fileNumber) {
        return levels[fileNumber].length;
    }

    public static int getNumberOfFiles() {
        return levels.length;
    }

    static char[][] getLevelData(int fileNumber, int levelNumber) {
        if (fileNumber >= levels.length || levelNumber >= levels[fileNumber].length || fileNumber < 0 || levelNumber < 0) {
            return new char[][]{{'X'}, {'X'}};
        } else {
            return levels[fileNumber][levelNumber];
        }
    }

    static String getFileName(int fileNumber) {
        return fileNameList.get(fileNumber);
    }


    private static ArrayList<ArrayList<ArrayList<String>>> readFiles()
            throws NullPointerException, FileNotFoundException, CharacterException {
        ArrayList<ArrayList<ArrayList<String>>> fileList = new ArrayList<>();
        if (levelDirectory.exists() && levelDirectory.listFiles().length != 0) {
            //go through all files
            for (File file : levelDirectory.listFiles()) {
                //find all .txt files
                if (file.getName().matches(".*.txt")) {
                    fileNameList.add(file.getName().replaceAll("(.*)(.txt)", "$1"));
                    ArrayList<ArrayList<String>> levelList = new ArrayList<>();
                    scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        ArrayList<String> level = new ArrayList<>();
                        //add all the lines of one level to an array list
                        while (!scanner.hasNext("\\s*;.*")) {
                            level.add(scanner.nextLine());
                        }
                        for (String line : level) {
                            if (line.matches("[^@# *.$+]*")) {
                                throw new CharacterException("Invalid Character",
                                        fileNameList.get(fileList.size()), levelList.size() + 1, level);
                            }
                        }
                        levelList.add(level);
                        //skip all the whitespace
                        while (scanner.hasNext("\\s*;.*")) {
                            scanner.nextLine();
                        }
                        scanner.nextLine();
                    }
                    fileList.add(levelList);
                }
            }
        } else {
            throw new NullPointerException("Level directory \"levels/\" does not exist or is empty");
        }
        return fileList;
    }

    private static char[][][][] parseLevels(ArrayList<ArrayList<ArrayList<String>>> fileList) throws CharacterException {
        int cols, rows, levelCount, lineIndex, fileCount = fileList.size(), levelIndex = 0;
        char[][][][] levels = new char[fileCount][][][];
        //for each file
        for (ArrayList<ArrayList<String>> file : fileList) {
            char[][][] fileData = new char[file.size()][][];
            levelCount = 0;
            //for each level in the file
            for (ArrayList<String> level : file) {
                rows = level.size();
                cols = 0;
                for (String line : level) {
                    cols = (cols < line.length()) ? line.length() : cols;
                }
                char[][] levelArray = new char[rows][cols];
                lineIndex = 0;
                //for each line in the level
                for (String line : level) {
                    //add the data to the char array by row
                    for (int i = 0; i < cols; i++) {
                        if (i < line.length()) {
                            levelArray[lineIndex][i] = line.charAt(i);
                        } else {
                            levelArray[lineIndex][i] = FLOOR;
                        }
                    }
                    lineIndex++;
                }
                fileData[levelCount++] = levelArray.clone();
            }
            levels[levelIndex++] = fileData.clone();
        }
        return levels;
    }
}
