import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String[] words;
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            input = scanner.nextLine();
            if (input.matches(""))
                input = scanner.nextLine();
            words = input.split(" +");
            for (String word : words) {
                if (word.matches("[a-z]+"))
                    System.out.print(word.substring(0, 1));
            }
            System.out.println();
        }
    }
}
