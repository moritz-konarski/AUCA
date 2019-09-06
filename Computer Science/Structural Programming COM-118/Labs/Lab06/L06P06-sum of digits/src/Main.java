import java.util.Scanner;
public class Main {

    public static int sumDigits(long n){
        int sumDigits = 0;
        int nDigits = (int)(Math.log10(n) + 1);
        for (int i = 0; i < nDigits; i++){
            sumDigits += n % 10;
            n /= 10;
        }
        return sumDigits;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        long n = scanner.nextLong();
        System.out.printf("The sum of all digits of %d is %d%n", n, sumDigits(n));
    }
}