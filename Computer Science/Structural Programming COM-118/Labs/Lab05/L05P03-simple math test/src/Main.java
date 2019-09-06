import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Number of tests: ");
        int testCases = scanner.nextInt();
        final int MAX = 100;
        final int MIN = -100;
        int x = 0;
        int y = 0;
        int result = 0;
        int trueCount = 0;
        int falseCount = 0;

        for (int i = 0; i < testCases; testCases--){
           x = random.nextInt(MAX + Math.abs(MIN) + 1) - Math.abs(MIN);
           y = random.nextInt(MAX + Math.abs(MIN) + 1) - Math.abs(MIN);
           System.out.printf("%d + %d = ", x, y);
           result = scanner.nextInt();
           if (x + y == result){
               trueCount++;
           }
           else {
               falseCount++;
           }
        }
        System.out.printf("Number of correct answers: %d\nNumber of incorrect answers: %d%n", trueCount, falseCount);
        System.out.printf("You got %.2f%% of tasks correct.", 100.0 * (trueCount)/(trueCount + falseCount));
    }
}
