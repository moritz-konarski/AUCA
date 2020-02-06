import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations, maxLength;
        String output;
        String[] strings;
        iterations = scanner.nextInt();
        while (iterations != 0) {
            maxLength = 0;
            strings = new String[iterations];
            for (int i = 0; i < iterations; i++) {
                strings[i] = scanner.next();
                maxLength = (strings[i].length() <= maxLength) ? maxLength : strings[i].length();
            }
            for (String string : strings) {
                output = ("%" + maxLength + "s%n");
                System.out.printf(output, string);
            }
            iterations = scanner.nextInt();
            if (iterations == 0)
                break;              //thus no trailing carriage returns
            System.out.println();
        }
    }
}
