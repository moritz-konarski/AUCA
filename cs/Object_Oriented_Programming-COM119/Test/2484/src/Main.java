import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] letters;
        int length;
        while (scanner.hasNext()) {
            letters = scanner.next().toCharArray();
            length = letters.length;
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < length; i++) {
                output = new StringBuilder();
                for (int k = 0; k < i; k++)
                    output.append(" ");
                for (int j = i; j < length - 1; j++)
                    output.append(letters[j - i]).append(" ");
                output.append(letters[length - 1 - i]).append("\n");
            }
            System.out.println(output.toString());
        }
    }
}