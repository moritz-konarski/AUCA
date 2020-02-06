import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int direction;
        char[] directions = {'N', 'L', 'S', 'O'};
        char[] commands;
        while (scanner.nextInt() != 0) {
            direction = 0;
            commands = scanner.next().toCharArray();
            for (char command : commands) {
                switch (command) {
                    case 'D':
                        direction++;
                        break;
                    case 'E':
                        direction--;
                        break;
                }
                direction = (direction > 3) ? 0 : direction;
                direction = (direction < 0) ? 3 : direction;
            }
            System.out.println(directions[direction]);
        }
    }
}
