import java.util.Scanner;
public class Main {
    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), maxValue;
        int[] letterCount;
        boolean[] indicesOfMax;
        char[] letters;
        String input;
        for (int i = 0; i < iterations; i++){
            indicesOfMax = new boolean[26];
            letterCount = new int[26];
            if ((input = scanner.nextLine()).equals(("")))
                input = scanner.nextLine();
            letters = input.toCharArray();
            for (char letter:letters){
                if (Character.isLetter(letter))
                    letterCount[(int) Character.toLowerCase(letter) - 97]++;
            }
            indicesOfMax[0] = true;
            maxValue = letterCount[0];
            for (int j = 1; j < letterCount.length; j++){
                if (letterCount[j] > maxValue) {
                    indicesOfMax = new boolean[26];
                    indicesOfMax[j] = true;
                    maxValue = letterCount[j];
                } else if (letterCount[j] == maxValue){
                    indicesOfMax[j] = true;
                }

            }
            for (int k = 0; k < letterCount.length; k++){
                if (indicesOfMax[k])
                    System.out.print((char) (k + 97));
            }
            System.out.println();
        }
    }
}
