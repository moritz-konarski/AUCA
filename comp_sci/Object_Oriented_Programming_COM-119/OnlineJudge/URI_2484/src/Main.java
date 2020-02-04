import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String word, output;
        ArrayList<String> parts = new ArrayList<>();
        while (scanner.hasNext()){
            parts.clear();
            word = scanner.next();
            parts.addAll(Arrays.asList(word.split("")));
            System.out.print(parts.get(0));
            parts.subList(1, word.length()).forEach(n -> System.out.print(" " + n));
            System.out.println();
            for (int j = 1; j < word.length() ; j++) {
                if (j > 1) {
                    output = "%" + (j - 1) + "s";
                    System.out.printf(output, "");
                }
                parts.subList(0, word.length() - j).forEach(n -> System.out.print(" " + n));
                System.out.println();
            }
            System.out.println();
        }
    }
}
