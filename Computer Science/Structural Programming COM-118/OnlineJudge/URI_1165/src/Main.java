import java.util.Scanner;
public class Main {

    public static boolean isPrime(int number){
        int divisors = 0;
        for (int i = 1; i <= number / 2; i++){
            divisors = (number % i == 0) ? ++divisors : divisors;
        }
        return (divisors == 1 || number == 1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++){
            int number = scanner.nextInt();
            if (isPrime(number)){
                System.out.println(number + " eh primo");
            }else{
                System.out.println(number + " nao eh primo");
            }
        }
    }
}
