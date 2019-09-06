import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), n, k, index;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= iterations; i++) {
            list.clear();
            n = scanner.nextInt();
            k = scanner.nextInt();
            for (int m = 1; m <= n; m++) {
                list.add(m);
            }
            index = k - 1;
            while (n-- > 1) {
                list.remove(index);
                index = (index + k - 1) % list.size();
            }
            System.out.printf("Case %d: %d%n", i, list.get(0));
        }
    }
}

/*
        boolean[] killed;
        for (int i = 1; i <= iterations; i++) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            killed = new boolean[n];
            index = 0;
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < k; ) {
                    index = ++index % n;
                    if (!killed[index]) {
                        m++;
                    }
                }
                killed[index] = true;
//                System.out.println(index);
            }
            System.out.printf("Case %d: %d%n", i, index);
//            System.out.printf("Case %d: %d%n", i, g(n, k) + 1);
        }
    }

//    private static int g(int n, int k) {
//        return (n == 0) ? 1 : (g(n - 1, k) + k) % n;
//    }
 */
