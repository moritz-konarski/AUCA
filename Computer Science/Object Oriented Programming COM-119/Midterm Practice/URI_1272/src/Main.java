import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(); scanner.nextLine();
        StringBuilder result;
        String[] input;
        for (int i = 0; i < iterations; i++){
            result = new StringBuilder();
            input = scanner.nextLine().trim().split("\\s+");
            if (input[0].length() != 0) {
                for (String word : input) {
                    result.append(word.charAt(0));
                }
            }
            System.out.println(result.toString());
        }
    }
}
