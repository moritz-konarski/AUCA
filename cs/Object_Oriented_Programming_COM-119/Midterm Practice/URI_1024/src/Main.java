import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        scanner.nextLine();
        char[] letters;
        for (int i = 0; i < iterations; i++) {
            letters = scanner.nextLine().trim().toCharArray();
            for (int k = 0; k < letters.length; k++) {
                if (Character.isLetter(letters[k])) {
                    letters[k] = (char) ((int) letters[k] + 3);
                }
            }
            for (int j = 0; j < letters.length / 2; j++) {
                char temp = letters[j];
                letters[j] = letters[letters.length - 1 - j];
                letters[letters.length - 1 - j] = temp;
            }
            for (int j = letters.length / 2; j < letters.length; j++) {
                letters[j] = (char) ((int) letters[j] - 1);
            }
            System.out.println(new String(letters));
        }
    }
}
