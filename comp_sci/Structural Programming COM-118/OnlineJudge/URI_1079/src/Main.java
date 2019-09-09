import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        float a = 0;
        float b = 0;
        float c = 0;
        float average = 0;
        for (int i = 0; i < testCases; i++){
            a = scanner.nextFloat();
            b = scanner.nextFloat();
            c = scanner.nextFloat();
            average = (2 * a + 3 * b + 5 * c) / 10;
            System.out.printf("%.1f%n", average);
        }
    }
}
