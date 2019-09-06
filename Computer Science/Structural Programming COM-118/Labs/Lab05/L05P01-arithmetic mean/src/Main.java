import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int n = 0;
        int sum = 0;

        while (true){
            number = scanner.nextInt();
            if (number == 0){
                break;
            }
            sum += number;
            n++;
        }
        System.out.printf("The arithmetic mean is %.1f\n", 1.0 * sum/n);
    }
}
