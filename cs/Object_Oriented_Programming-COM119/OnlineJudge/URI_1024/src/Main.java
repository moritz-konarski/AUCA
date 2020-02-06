import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int[] charCodes;
        char[] letters;
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            input = scanner.nextLine();
            if (input.equals("") || input.equals("\n")) {               //URI does not recognize .isEmpty(), thus I do it like this
                input = scanner.nextLine();
            }
            letters = input.toCharArray();
            charCodes = new int[letters.length];
            for (int j = 0; j < charCodes.length; j++) {
                charCodes[charCodes.length - 1 - j] = letters[j];       //reverse order and increase by three
                if (charCodes[charCodes.length - 1 - j] > 64 && charCodes[charCodes.length - 1 - j] < 91 ||         //A-Z
                        charCodes[charCodes.length - 1 - j] > 96 && charCodes[charCodes.length - 1 - j] < 123) {    //a-z
                    charCodes[charCodes.length - 1 - j] += 3;
                }
            }
            for (int k = charCodes.length - 1; k >= charCodes.length / 2; k--) {
                charCodes[k]--;                                         //decrease by one
            }
            for (int charCode : charCodes) {
                System.out.print((char) charCode);
            }
            System.out.println();
        }
    }
}
