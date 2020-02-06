import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double[] nArray = new double[100];
        for (int i = 0; i < 100; i++) {
            nArray[i] = scanner.nextDouble();
            if (nArray[i] <= 10) {
                System.out.printf("A[%d] = %.1f%n", i, nArray[i]);
            }
        }
    }
}
