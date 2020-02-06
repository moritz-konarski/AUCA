import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), result;
        String input;
        for (int i = 0; i < iterations; i++){
            input = scanner.next();
            if (input.length() == 5){
                result = 3;
            } else {
                if (input.matches(".wo|t.o|tw."))
                    result = 2;
                else
                    result = 1;
            }
            System.out.println(result);
        }
    }
}
