import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] correctAnswers = new int[8];
        String[] key = {"D", "B", "D", "C", "C", "D", "A", "E", "A", "D"};
        String[][] studentAnswers = new String[8][10];

        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.printf("Student %d's answers: ", i);
            for (int j = 0; j < studentAnswers[0].length; j++) {
                studentAnswers[i][j] = scanner.next();
                correctAnswers[i] = (studentAnswers[i][j].equals(key[j])) ? ++correctAnswers[i] : correctAnswers[i];
            }
        }
        for (int k = 0; k < correctAnswers.length; k++){
            System.out.printf("Student %d's correct answers: %d of 10.%n", k, correctAnswers[k]);
        }
    }
}
