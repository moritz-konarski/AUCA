import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean funny = true;
        input = scanner.nextLine();
        input = input.replaceAll("[^aeiou]", "");
        int offset = input.length() - 1;
        for (int i = 0; i <= offset; i++) {
            if (!(input.charAt(i) == input.charAt(offset - i))) {
                System.out.println("N");
                funny = false;
                break;
            }
        }
        if (funny)
            System.out.println("S");
    }
}
