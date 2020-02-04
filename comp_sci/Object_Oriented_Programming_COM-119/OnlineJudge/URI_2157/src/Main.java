import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), a, b;
        String output;
        for (int i = 0; i < iterations; i++){
            output = "";
            a = scanner.nextInt();
            b = scanner.nextInt();
            for (int j = a; j <= b; j++){
                output = output.concat(String.valueOf(j));
            }
            for (int j = output.length() - 1; j >= 0 ; j--){
                output = output.concat(String.valueOf(output.charAt(j)));
            }
            System.out.println(output);
        }
    }
}
