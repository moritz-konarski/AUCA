import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        float x = 0;
        float y = 0;
        float result = 0;
        for (int i = 0; i < testCases; i++){
            x = scanner.nextFloat();
            y = scanner.nextFloat();
            if (y == 0){
                System.out.println("divisao impossivel");
                continue;
            }
            result = x / y;
            System.out.printf("%.1f%n", result);
        }
    }
}
