import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            char sentence[] = s.toCharArray();

            for (int i = 0, j = 0; i < sentence.length; i++) {
                if (Character.isLetter(sentence[i])){
                    if (j % 2 == 0) {
                        System.out.print(Character.toUpperCase(sentence[i]));
                    } else {
                        System.out.print(Character.toLowerCase(sentence[i]));
                    }
                    j++;
                } else {
                    System.out.print(sentence[i]);
                }
            }
            System.out.println();
        }
    }
}