import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] input;
        while (scanner.hasNext()){
            input = scanner.nextLine().toCharArray();
            for (int i = 0, j = 0; i < input.length; i++){
                if (Character.isLetter(input[i])){
                    input[i] = (j % 2 == 0) ? Character.toUpperCase(input[i]) : Character.toLowerCase(input[i]);
                    j++;
                }
            }
            System.out.println(new String(input));
        }
    }
}
