import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        String input;
        String[] numbers;
        for (int i = 0; i < iterations; i++) {
            input = scanner.nextLine();
            if (input.equals(""))
                input = scanner.nextLine();
            numbers = input.split(" ");
            if (numbers[0].endsWith(numbers[1])) {
                System.out.println("encaixa");
            } else {
                System.out.println("nao encaixa");
            }
        }
    }
}