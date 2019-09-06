import java.util.Scanner;

public class Main {

    //static variables
    final private static String[] validCommands = {
            "PenUp", "PenDown",
            "TurnRight", "TurnLeft", "TurnBack",
            "Move", "Print", "Reset",
            "ResetPos", "Exit"};

    //read the commands
    private static boolean readCommand(Turtle turtle, Field field) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] commands = input.split(" ");
        commands[0] = commands[0].toLowerCase();
        switch (commands[0]) {
            case "penup":
                turtle.setPenUp();
                break;
            case "pendown":
                turtle.setPenDown();
                break;
            case "print":
                field.print(turtle);
                break;
            case "turnright":
                turtle.turnRight();
                break;
            case "turnleft":
                turtle.turnLeft();
                break;
            case "turnback":
                turtle.turnBack();
                break;
            case "move":
                turtle.move(commands[1], field);
                break;
            case "reset":
                field.reset();
                System.out.println("Reset Field.");
                break;
            case "resetpos":
                turtle.reset();
                System.out.println("Reset Position.");
                break;
            case "exit":
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

    //main loop
    public static void main(String[] args) {
        Turtle turtle = new Turtle(0, 0);
        Field field = new Field(20, 20);
        while (readCommand(turtle, field)) ;
    }
}
