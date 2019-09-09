import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int cipherKey, newValue;
        int[] charCodes;
        char[] letters;
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            input = scanner.nextLine();
            if (input.equals(""))
                input = scanner.nextLine();
            cipherKey = scanner.nextInt();
            letters = input.toCharArray();
            charCodes = new int[letters.length];
            for (int j = 0; j < charCodes.length; j++) {
                newValue = (letters[j] - 64 - cipherKey) % 26;
                charCodes[j] = (newValue > 0) ? newValue + 64 : newValue + 90;
            }
            for (int charCode : charCodes) {
                System.out.print((char) charCode);
            }
            System.out.println();
        }
    }
}
