import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance;
        double angle = 0;
        String[] commands;
        String[] input = new String[0];
        boolean penDown = true;
        boolean skipScanner = false;
        boolean continueLoop = true;
        int[] position = new int[2];                //[x][y]
        final String[] validCommands = {"PenUp", "PenDown", "TurnRight", "TurnLeft", "Move", "Print", "Pos", "Reset", "ResetPos", "Exit", "ChessPattern"};
        boolean[][] board = new boolean[20][20];    //[y][x]

        while (continueLoop) {
            if (!skipScanner) {
                input = new String[1];
                input[0] = scanner.nextLine();
            }
            for (String inputLine : input) {
                if (inputLine.contains(" ")) {
                    commands = new String[2];
                    commands = inputLine.split(" ");
                } else {
                    commands = new String[1];
                    commands[0] = inputLine;
                }
                for (int k = 0; k < commands.length; k++) {
                    if (k == commands.length - 1) {
                        skipScanner = false;
                    }
                    switch (commands[k]) {
                        case "PenUp":
                            penDown = false;
                            break;
                        case "PenDown":
                            penDown = true;
                            break;
                        case "TurnRight":
                            angle -= Math.PI / 2;
                            break;
                        case "TurnLeft":
                            angle += Math.PI / 2;
                            break;
                        case "Move":
                            k++;
                            distance = Integer.parseInt(commands[k]);
                            for (int n = distance; n > 0; n--) {
                                try {
                                    board[position[1]][position[0]] = penDown;
                                    position[0] += Math.round(Math.cos(angle));
                                    position[1] -= Math.round(Math.sin(angle));
                                } catch (IndexOutOfBoundsException e) {
                                    System.err.println("You reached the edge!");
                                    break;
                                }
                            }
                            break;
                        case "Print":
                            for (boolean[] row : board) {
                                for (boolean isPenDown : row) {
                                    if (isPenDown) {
                                        System.out.print(" *");
                                    } else {
                                        System.out.print(" .");
                                    }
                                }
                                System.out.println();
                            }
                            break;
                        case "Exit":
                            System.out.println("Exiting...");
                            continueLoop = false;
                            break;
                        case "Reset":
                            board = new boolean[20][20];
                            angle = 0;
                            position = new int[2];
                            System.out.println("Board is reset.");
                            break;
                        case "ResetPos":
                            angle = 0;
                            position = new int[2];
                            System.out.println("Position is reset.");
                            break;
                        case "Pos":
                            System.out.printf("(%d, %d) -- Direction (%.0f, %.0f)%n", position[0], position[1], Math.cos(angle), Math.sin(angle));
                            break;
                        case "ChessPattern":
                            int counter = 0;
                            input = new String[842];
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board.length - 1; j++) {
                                    input[counter] = ((j % 2) == 0) ? "PenUp" : "PenDown";
                                    counter++;
                                    input[counter] = "Move 1";
                                    counter++;
                                }
                                if (i % 2 == 0) {
                                    input[counter] = "PenDown";
                                    counter++;
                                    input[counter] = "TurnRight";
                                    counter++;
                                    input[counter] = "Move 1";
                                    counter++;
                                    input[counter] = "TurnRight";
                                    counter++;
                                } else {
                                    input[counter] = "PenDown";
                                    counter++;
                                    input[counter] = "TurnLeft";
                                    counter++;
                                    input[counter] = "Move 1";
                                    counter++;
                                    input[counter] = "TurnLeft";
                                    counter++;
                                }
                            }
                            input[counter] = "Print";
                            counter++;
                            input[counter] = "ResetPos";
                            skipScanner = true;
                            break;
                        default:
                            System.err.printf("Command <%s> is not valid. Try:%n", commands[k]);
                            for (String goodCommand : validCommands) {
                                System.out.printf("- %s%n", goodCommand);
                            }
                            break;
                    }
                }
            }
        }
    }
}