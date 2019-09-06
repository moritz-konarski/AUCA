import java.util.Scanner;
public class Main {

    public static int gdc(int a, int b){
        if (a < 1 || b < 1){
            throw new IllegalArgumentException("argument is zero or negative");
        }
        int gcd = 0;
        int min = Math.min(a, b);
        min = Math.min(min, Math.max(a, b) / 2);
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("A: ");
        int a = scanner.nextInt();
        System.out.print("B: ");
        int b = scanner.nextInt();
        try {
            System.out.printf("GCD(%d, %d) = %d%n", a, b, gdc(a, b));
        }
        catch (IllegalArgumentException e){
            System.err.printf("GCD(%d, %d) is not defined%n", a, b);
            System.exit(-1);
        }
    }
}
