import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(); scanner.nextLine();
        char[] input, result;
        for (int i = 0; i < iterations; i++){
            input = scanner.nextLine().toCharArray();
            result = new char[input.length];
            System.arraycopy(input, input.length / 2, result, 0, input.length - (input.length / 2));
            System.arraycopy(input, 0, result, result.length / 2, input.length / 2);
            for (int j = result.length - 1; j >= 0; j--) {
                System.out.print(result[j]);
            }
            System.out.println();
        }
    }
}
