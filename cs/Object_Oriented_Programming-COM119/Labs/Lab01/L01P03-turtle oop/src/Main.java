import java.util.Scanner;

public class Main {

    //static variables
    static char[][] field;
    final static int ROWS = 20;
    final static int COLS = 20;
    final static String[] validCommands = {
            "PenUp", "PenDown",
            "TurnRight", "TurnLeft",
            "Move", "Print", "Reset",
            "ResetPos", "Exit"};

    public static void printField() {
        for (char[] row : field) {
            for (char spot : row) {
                System.out.printf("%c ", spot);
            }
            System.out.println();
        }
    }

    public static void resetField(Turtle turtle){
        field = new char[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                field[row][col] = turtle.UNMARKED;
            }
        }
        field[turtle.posY][turtle.posX] = turtle.SIGN;
    }

    public static boolean readCommand(Turtle turtle) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] commands = input.split(" ");
        switch (commands[0]) {
            case "PenUp":
                turtle.penUp();
                break;
            case "PenDown":
                turtle.penDown();
                break;
            case "Print":
                printField();
                break;
            case "TurnRight":
                turtle.turnRight();
                break;
            case "TurnLeft":
                turtle.turnLeft();
                break;
            case "Move":
                turtle.move(commands[1], field);
                break;
            case "Reset":
                resetField(turtle);
                System.out.println("Reset Field");
                break;
            case "ResetPos":
                turtle.reset(field);
                break;
            case "Exit":
                System.out.println("Exiting...");
                return false;
            default:
                System.err.println("Command not valid. Try:");
                for (String command : validCommands) {
                    System.err.printf("- %s%n", command);
                }
                break;
        }
        return true;
    }

    public static void main(String[] args) {
        Turtle turtle = new Turtle(0, 0);
        resetField(turtle);
        while(readCommand(turtle));
    }
}
