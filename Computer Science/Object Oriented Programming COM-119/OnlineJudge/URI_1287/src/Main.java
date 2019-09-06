import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long result;
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            input = input.replaceAll("[, ]", "");
            if (input.equals("")) {
                System.out.println("error");
                continue;
            }
            input = input.replaceAll("[oO]", "0");
            input = input.replaceAll("[l]", "1");
            if (input.matches(".*\\D.*")) {
                System.out.println("error");
                continue;
            }
            result = Long.parseLong(input);
            if (result > 2147483647 || result < 0) {
                System.out.println("error");
                continue;
            }
            System.out.println(result);
        }
    }
}
