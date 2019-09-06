import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int testCases = 2;
        int n = 0;
        float x = 0;
        float y = 0;
        float sum = 0;
        do {
            x = scanner.nextFloat();
            if (x >= 0 && x <= 10){
                sum += x;
                n++;
            }
            else {
                System.out.println("nota invalida");
            }
        }while (n < testCases);
        System.out.printf("media = %.2f%n", sum / 2);
    }
}
