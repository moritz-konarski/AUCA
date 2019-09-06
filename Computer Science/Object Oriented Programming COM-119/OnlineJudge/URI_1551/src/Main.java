import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input, output;
        boolean[] contains;
        int iterations = scanner.nextInt(), completeness;
        for (int j = 0; j < iterations; j++) {
            contains = new boolean[26];
            completeness = 0;
            if ((input = scanner.nextLine()).equals(""))
                input = scanner.nextLine();
            input = input.replaceAll("[^\\w]", "");
            for (int i = 0; i < input.length(); i++) {
                contains[input.codePointAt(i) - 97] = true;
            }
            for (boolean contained : contains) {
                if (contained)
                    completeness++;
            }
            if (completeness == 26) {
                output = "frase completa";
            } else if (completeness >= 13) {
                output = "frase quase completa";
            } else {
                output = "frase mal elaborada";
            }
            System.out.println(output);
        }
    }
}
