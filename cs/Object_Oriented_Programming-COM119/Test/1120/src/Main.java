import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] numbers;
        while (!(input = scanner.nextLine()).equals("0 0")) {
            numbers = input.split(" ");
            numbers[1] = numbers[1].replace(numbers[0], "");
            numbers[1] = numbers[1].replaceFirst("0+", "");
            System.out.println(numbers[1].equals("") ? "0" : numbers[1]);
        }
    }
}