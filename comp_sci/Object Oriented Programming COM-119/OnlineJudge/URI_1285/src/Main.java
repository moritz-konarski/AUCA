import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, count;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            count = 0;
            for (; n <= m; n++) {
                if (!hasRepeatedDigits(n)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean hasRepeatedDigits(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        int digit;
        for (int i = 1; i <= n; i *= 10) {
            digit = (n / i) % 10;
            if (!digits.contains(digit))
                digits.add(digit);
            else
                return true;
        }
        return false;
    }
}
