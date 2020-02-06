import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int takeValue, testCase;
        String totalLed;
        testCase = scanner.nextInt();
        for (int i = 1; i <= testCase; i++) {
            int everyValue = 0;
            totalLed = "";
            takeValue = scanner.nextInt();

            while (takeValue != 0) {
                everyValue =(takeValue % 10);
                takeValue /= 10;
                totalLed += everyValue;
            }
            System.out.println(totalLed+" leds");
        }
    }
}