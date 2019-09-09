import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Integer: ");
        int number = scanner.nextInt();
        int digits = (int)Math.ceil(Math.log10(number));
        int sum = 0;
        for (int i = 0; i < digits; i++){
            sum += number % 10;
            number /= 10;
        }
        System.out.println("The sum of all digits is " + sum);
    }
}
