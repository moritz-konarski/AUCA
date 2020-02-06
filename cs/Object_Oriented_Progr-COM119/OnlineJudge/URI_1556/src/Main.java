import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> permutations = new ArrayList<>();
        String input;
        String permutation;
        int length;
        while (scanner.hasNext()) {
            input = scanner.next().trim();
            length = input.length();
            // length of substring
            for (int curLength = 1; curLength <= length; curLength++){
                // offset of substring
                for (int j = 0; j <= length - curLength; j++){
                    permutation = input.substring(j, j + curLength);
                    if (!permutations.contains(permutation))
                        permutations.add(permutation);
                    for (String element : input.split(permutation)) {
                        if (!permutations.contains(element))
                            permutations.add(element);
                    }
                    permutation = input.replace(permutation, "");
                    if (!permutations.contains(permutation))
                        permutations.add(permutation);
                }
            }

            Collections.sort(permutations);
            permutations.forEach(System.out::println);
            System.out.println();
            permutations.clear();
        }
    }
}
