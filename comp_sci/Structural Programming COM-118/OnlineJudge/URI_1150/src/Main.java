import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int z, n = 1;
        int x = scanner.nextInt();
        do {
            z = scanner.nextInt();
        } while (z <= x);
        int X = x;
        do {
            X += (x + n++);
        } while (X <= z);
        System.out.println(n);
    }
}