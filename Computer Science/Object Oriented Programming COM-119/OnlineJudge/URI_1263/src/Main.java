import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int alliterations;
        String input;
        String[] words;
        char[] firstLetters;
        while (scanner.hasNext()) {
            alliterations = 0;
            if ((input = scanner.nextLine()).equals(""))
                input = scanner.nextLine();
            words = input.split(" ");
            firstLetters = new char[words.length];
            for (int i = 0; i < words.length; i++) {
                firstLetters[i] = words[i].toLowerCase().charAt(0);
            }
            for (int j = 0; j < firstLetters.length - 1; j++) {
                if (firstLetters[j] == firstLetters[j + 1]) {
                    alliterations++;
                    while (firstLetters[j] == firstLetters[j + 1] && j < firstLetters.length - 2) {
                        j++;
                    }
                }
            }
            System.out.println(alliterations);
        }
    }
}
