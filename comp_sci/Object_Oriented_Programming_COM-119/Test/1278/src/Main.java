import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()), max;
        while (true) {
            max = 0;
            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = scanner.nextLine().trim().replaceAll("\\s+", " ");
                max = (lines[i].length() > max) ? lines[i].length() : max;
            }
            for (String line : lines)
                System.out.printf("%" + max + "s%n", line);
            if ((n = Integer.parseInt(scanner.nextLine())) == 0)
                break;
            System.out.println();
        }
    }
}