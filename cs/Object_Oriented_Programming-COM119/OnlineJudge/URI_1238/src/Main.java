import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int maxLengthIndex, minLengthIndex;
        char[][] inputWord = new char[2][];
        char[] finalWord;
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            input = scanner.next();
            inputWord[0] = input.toCharArray();
            input = scanner.next();
            inputWord[1] = input.toCharArray();
            maxLengthIndex = (inputWord[1].length > inputWord[0].length) ? 1 : 0;
            minLengthIndex = Math.abs(maxLengthIndex - 1);
            finalWord = new char[inputWord[1].length + inputWord[0].length];
            for (int j = 0; j < 2 * inputWord[minLengthIndex].length; j++) {
                if (j % 2 == 0) {
                    finalWord[j] = inputWord[0][j / 2];
                } else {
                    finalWord[j] = inputWord[1][j / 2];
                }
            }
            for (int k = 2 * inputWord[minLengthIndex].length; k < finalWord.length; k++) {
                finalWord[k] = inputWord[maxLengthIndex][k - inputWord[minLengthIndex].length];
            }
            for (char $char : finalWord) {
                System.out.print($char);
            }
            System.out.println();
        }
    }
}
