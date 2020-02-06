import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        long[] fibonacci = new long[61];
        long x, y, z;
        x = 0;
        y = 1;
        for (int i = 0; i < 61; i++){
            fibonacci[i] = x;
            z = x + y;
            x = y;
            y = z;
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int j = 0; j < n; j++) {
            int index = scanner.nextInt();
            System.out.printf("Fib(%d) = %d%n", index, fibonacci[index]);
        }
    }
}
