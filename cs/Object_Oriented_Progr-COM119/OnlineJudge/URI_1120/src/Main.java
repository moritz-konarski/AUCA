import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input, regex1, regex2, finalRagex, newNumber;
        String[] numbers;
        while (!(input = scanner.nextLine()).equals("0 0")) {
            numbers = input.split(" ");
            regex1 = String.format("%s", numbers[0]);
            regex2 = "^(0+)";
            newNumber = numbers[1].replaceAll(regex1, "");
            newNumber = newNumber.replaceAll(regex2, "");
            newNumber = (newNumber.equals("")) ? "0" : newNumber;
            System.out.println(newNumber);
        }
    }
}