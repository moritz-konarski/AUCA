import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] characters;
        int iterations = scanner.nextInt();
        long mutations;
        for (int i = 0; i < iterations; i++){
            mutations = 1;
            input = scanner.next().toUpperCase().trim();
            characters = input.split("");
            for (String letter:characters){
                if (letter.matches("[AEIOS]"))
                    mutations *= 3;
                else
                    mutations *= 2;
            }
            System.out.println(mutations);
        }
    }
}
