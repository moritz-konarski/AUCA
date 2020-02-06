import java.util.Scanner;
public class Main {

    public static int gcdEuclideanAlgorithm(int a, int b){
        if (a < 1 || b < 1){
            throw new IllegalArgumentException("argument is zero or negative");
        }
        int max = Math.max(a, b);
        int gcd = Math.min(a, b);
        int remainder = 0;
        while (true) {
            remainder = max % gcd;      //this uses a the euclidean algorithm for finding the gcd
            if (remainder == 0){
                return gcd;}
            max = gcd;
            gcd = remainder;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("A: ");
        int a = scanner.nextInt();
        System.out.print("B: ");
        int b = scanner.nextInt();
        try {
            System.out.printf("GCD(%d, %d) = %d%n", a, b, gcdEuclideanAlgorithm(a, b));
        }
        catch (IllegalArgumentException e){
            System.err.printf("GCD(%d, %d) is not defined%n", a, b);
            System.exit(-1);
        }
    }
}
