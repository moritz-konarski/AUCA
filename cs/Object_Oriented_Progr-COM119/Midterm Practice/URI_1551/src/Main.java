import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), letterCount; scanner.nextLine();
        boolean[] trueSentence;
        char[] input;
        for (int i = 0; i < iterations; i++){
            trueSentence = new boolean[26];
            letterCount = 0;
            input = scanner.nextLine().trim().toCharArray();
            for (char character : input){
                if (Character.isLetter(character))
                    trueSentence[character - 'a'] = true;
            }
            for (boolean contained : trueSentence){
                letterCount = (contained) ? ++letterCount : letterCount;
            }
            if (letterCount == 26)
                System.out.println("frase completa");
            else if (letterCount >= 13)
                System.out.println("frase quase completa");
            else
                System.out.println("frase mal elaborada");
        }
    }
}
