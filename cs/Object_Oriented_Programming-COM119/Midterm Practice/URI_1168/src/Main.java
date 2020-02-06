import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), leds;
        int[] values = new int[] {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        for (int i = 0; i < iterations; i++) {
            String number = scanner.next().trim();
            leds = 0;
            for (int k = 0; k < number.length(); k++)
                leds += values[Integer.parseInt(number.substring(k, k + 1))];
            System.out.println(leds + " leds");
        }
    }
}
