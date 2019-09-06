import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations, input;
        char output;
        boolean oneMarked;

        while((iterations = scanner.nextInt()) > 0) {
            for (int i = 0; i < iterations; i++) {
                output = '*';
                oneMarked = false;
                for (int j = 0; j < 5; j++) {
                    input = scanner.nextInt();
                    if (input < 128 && !oneMarked) {
                        output = (char) (j + 65);
                        oneMarked = true;
                    } else if (input < 128) {
                        output = '*';
                        scanner.nextLine();
                        break;
                    }
                }
                System.out.println(output);
            }
        }
    }
}
