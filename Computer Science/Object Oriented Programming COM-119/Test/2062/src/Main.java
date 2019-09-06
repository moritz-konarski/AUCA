import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        scanner.nextInt();
        scanner.skip("\\s*");
        word = scanner.nextLine();
        word = word.replaceAll("\\s*UR[^I]\\s*", " URI ");
        word = word.replaceAll("\\s*OB[^I]\\s*", " OBI ");
        System.out.println(word.trim());
    }
}
