import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input, longestWord = "";
        String[] words;
        while (!(input = scanner.nextLine()).equals("0")) {
            StringBuilder output = new StringBuilder();
            words = input.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (i == 0)
                    output.append(words[i].length());
                else
                    output.append("-").append(words[i].length());
                longestWord = (longestWord.length() <= words[i].length()) ? words[i] : longestWord;
            }
            System.out.println(output);
        }
        System.out.printf("%nThe biggest word: %s%n", longestWord);
    }
}
