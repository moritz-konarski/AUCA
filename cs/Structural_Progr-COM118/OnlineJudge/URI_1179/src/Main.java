import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] even = new int[5];
        int evenIndex = 0;
        int oddIndex = 0;
        int[] odd = new int[5];
        for (int j = 0; j < 15; j++) {
            int n = scanner.nextInt();
            if (n % 2 == 0) {
                even[evenIndex] = n;
                evenIndex++;
                if (evenIndex > 4) {
                    for (int i = 0; i < even.length; i++) {
                        System.out.printf("par[%d] = %d%n", i, even[i]);
                    }
                    evenIndex = 0;
                    even = new int[5];
                }
            } else {
                odd[oddIndex] = n;
                oddIndex++;
                if (oddIndex > 4) {
                    for (int i = 0; i < odd.length; i++) {
                        System.out.printf("impar[%d] = %d%n", i, odd[i]);
                    }
                    oddIndex = 0;
                    odd = new int[5];
                }
            }
        }
        for (int i = 0; i < oddIndex; i++) {
            System.out.printf("impar[%d] = %d%n", i, odd[i]);
        }
        for (int j = 0; j < evenIndex; j++) {
            System.out.printf("par[%d] = %d%n", j, even[j]);
        }
    }
}
