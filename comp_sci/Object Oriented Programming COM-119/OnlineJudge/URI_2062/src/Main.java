import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word, output = "";
        int words = scanner.nextInt();
        for (int i = 0; i < words; i++) {
            word = scanner.next();
            if (word.length() == 3) {
                word = word.replaceAll("UR[^I]", "URI");
                word = word.replaceAll("OB[^I]", "OBI");
            }
            if (i < words - 1)
                System.out.printf("%s ", word);
            else
                System.out.printf("%s%n", word);
        }
    }
}
