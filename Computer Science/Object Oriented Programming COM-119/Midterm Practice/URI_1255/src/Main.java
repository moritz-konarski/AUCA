import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), max; scanner.nextLine();
        char[] input;
        int[] count;
        boolean[] maxIndex;
        for (int i = 0; i < iterations; i++){
            count = new int[26];
            maxIndex = new boolean[26];
            max = 0;
            input = scanner.nextLine().toLowerCase().toCharArray();
            for (char letter : input){
                if (Character.isLetter(letter)){
                    count[(int) letter - 'a']++;
                }
            }
            for (int j = 0; j < count.length; j++){
                if (count[j] == max){
                    maxIndex[j] = true;
                } else if (count[j] > max){
                    maxIndex = new boolean[26];
                    maxIndex[j] = true;
                    max = count[j];
                }
            }
            for (int k = 0; k < count.length; k++){
                if (maxIndex[k])
                    System.out.print((char) (k + 'a'));
            }
            System.out.println();
        }
    }
}
