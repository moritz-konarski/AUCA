import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> difference;
        int[] input;
        int n, b;
        char out;
        while ((n = scanner.nextInt()) != 0 && (b = scanner.nextInt()) != 0) {
            input = new int[b];
            difference = new ArrayList<>();
            out = 'Y';
            for (int i = 0; i < b; i++) {
                input[i] = scanner.nextInt();
            }
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < b; k++) {
                    difference.add(Math.abs(input[j] - input[k]));
                }
            }
            for (int m = 1; m <= n; m++) {
                if (!difference.contains(m)) {
                    out = 'N';
                    break;
                }
            }
            System.out.println(out);
        }
    }
}
