import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCodes, min2, min;
        int[] codes, orderedCodes;
        while (scanner.hasNext()) {
            nCodes = scanner.nextInt();
            min2 = min = 10000;
            orderedCodes = new int[nCodes];
            codes = new int[nCodes];
            for (int i = 0; i < nCodes; i++) {
                codes[i] = scanner.nextInt();
                min = (min > codes[i]) ? codes[i] : min;
            }
            orderedCodes[0] = min;
            for (int k = 1; k < nCodes; k++) {
                for (int j = 0; j < nCodes; j++)
                    min2 = (codes[j] > min && codes[j] < min2) ? codes[j] : min2;
                orderedCodes[k] = min2;
                min = min2;
                min2 = 10000;
            }
            for (int code : orderedCodes) {
                System.out.printf("%04d%n", code);
            }
        }
    }
}
