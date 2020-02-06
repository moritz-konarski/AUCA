import java.util.Scanner;


public class Main {
    private static String[] commands, originalCommands;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        int nCommands;
        for (int i = 0; i < iterations; i++) {
            nCommands = scanner.nextInt();
            scanner.nextLine();
            commands = new String[nCommands];
            for (int j = 0; j < nCommands; j++) {
                commands[j] = scanner.nextLine();
            }
            originalCommands = commands.clone();
            System.out.println(getPosition(commands));
        }
    }

    private static int getPosition(String[] commands) {
        int position = 0;
        for (String command : commands) {
            switch (command) {
                case "LEFT":
                    position--;
                    break;
                case "RIGHT":
                    position++;
                    break;
                default:
                    position += getPosition(new String[]
                            {originalCommands[Integer.parseInt(command.replaceAll("(\\D+)(\\d+)", "$2")) - 1]});
                    break;
            }
        }
        return position;
    }
}
