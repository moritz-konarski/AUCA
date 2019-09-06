import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), shift, value;
        char[] input;
        for (int i = 0; i < iterations; i++){
            input = scanner.next().toCharArray();
            shift = scanner.nextInt();
            for (int k = 0; k < input.length; k++){
                value = ((int) input[k] - shift < 'A') ? (int) input[k] - shift + 26 : (int) input[k] - shift;
                input[k] = (char) value;
            }
            System.out.println(new String(input));
        }
    }
}
