import java.util.Scanner;

public class Main {

    static double angle;
    static boolean penUp;
    static int[] position;
    static char[][] field;
    final static char TURTLE_SIGN = 't';
    final static char MARKED = '*';
    final static char UNMARKED = '.';
    final static int ROWS = 20;
    final static int COLS = 20;
    final static String[] validCommands =
                    {"PenUp", "PenDown",
                    "TurnRight", "TurnLeft",
                    "Move", "Print", "Reset",
                    "ResetPos", "Exit"};

    public static void initTurtle() {
        angle = 0;
        position = new int[2];
        penUp = true;
        field[position[1]][position[0]] = TURTLE_SIGN;
    }

    public static void initVariables() {
        field = new char[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                field[row][col] = UNMARKED;
            }
        }
    }

    public static void printField() {
        for (char[] row : field) {
            for (char spot : row) {
                System.out.printf("%c ", spot);
            }
            System.out.println();
        }
    }

    public static void Move(String distance) {
        int xMovement = (int) Math.cos(angle);
        int yMovement = (int) Math.sin(angle);
        for (int i = 0; i < Integer.parseInt(distance); i++) {
            if (!penUp)
                field[position[1]][position[0]] = MARKED;
            else if (field[position[1]][position[0]] == TURTLE_SIGN)
                field[position[1]][position[0]] = UNMARKED;
            if (position[0] + xMovement >= COLS || position[1] + yMovement >= ROWS ||
                    position[0] + xMovement < 0 || position[1] + yMovement < 0) {
                System.err.println("Hit the edge!");
                break;
            }
            position[0] += xMovement;
            position[1] += yMovement;
        }
        field[position[1]][position[0]] = TURTLE_SIGN;
    }

    public static boolean readCommand() {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        String[] commands = input.split(" ");
        switch (commands[0]) {
            case "PenUp":
                penUp = true;
                break;
            case "PenDown":
                penUp = false;
                break;
            case "Print":
                printField();
                break;
            case "TurnRight":
                angle += Math.PI / 2;
                break;
            case "TurnLeft":
                angle -= Math.PI / 2;
                break;
            case "Move":
                Move(commands[1]);
                break;
            case "Reset":
                initTurtle();
                initVariables();
                break;
            case "ResetPos":
                field[position[1]][position[0]] = MARKED;
                initTurtle();
                break;
            case "Exit":
                System.out.println("Exiting...");
                System.exit(0);
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
        initVariables();
        initTurtle();
        while (readCommand()) ;
    }
}
