import java.util.Scanner;
public class Main {

    public static boolean isPerfect(int number){
        int divisorSum = 0;
        for (int i = 1; i <= number / 2; i++){
            divisorSum = (number % i == 0) ?  divisorSum + i : divisorSum;
        }
        return (divisorSum == number);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++){
            int number = scanner.nextInt();
            if (isPerfect(number)){
                System.out.println(number + " eh perfeito");
            }else{
                System.out.println(number + " nao eh perfeito");
            }
        }
    }
}
