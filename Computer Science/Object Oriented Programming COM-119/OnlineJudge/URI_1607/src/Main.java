import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), firstChar ,secondChar, nOps;
        String input;
        String[] strings;
        char[][] chars = new char[2][];
        for (int i = 0; i < iterations; i++) {
            nOps = 0;
            if (!(input = scanner.nextLine()).matches("\\w.*"))
                input = scanner.nextLine();
            strings = input.split(" ");
            if (strings[0].equals(strings[1])) {
                System.out.println("0");
                continue;
            }
            chars[0] = strings[0].toCharArray();
            chars[1] = strings[1].toCharArray();
            for (int j = 0; j < chars[0].length; j++){
                firstChar = (int) chars[0][j];
                secondChar = (int) chars[1][j];
                if (firstChar <= secondChar){
                    nOps += secondChar - firstChar;
                } else {
                    nOps += secondChar - firstChar + 26;
                }
            }
            System.out.println(nOps);
        }
    }
}
