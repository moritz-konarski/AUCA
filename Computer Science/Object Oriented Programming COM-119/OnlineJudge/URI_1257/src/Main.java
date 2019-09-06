import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), nLines, hash;
        String input;
        char[] $chars;
        for (int i = 0; i < iterations; i++) {
            hash = 0;
            nLines = scanner.nextInt();
            for (int j = 0; j < nLines; j++) {
                if ((input = scanner.nextLine()).equals(""))
                    input = scanner.nextLine();
                $chars = input.toCharArray();
                for (int k = 0; k < $chars.length; k++) {
                    hash += k + (int) $chars[k] - 65 + j;
                }
            }
            System.out.println(hash);
        }
    }
}
