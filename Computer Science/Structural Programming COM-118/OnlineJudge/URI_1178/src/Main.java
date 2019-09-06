import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double[] array = new double[100];
        array[0] = scanner.nextDouble();
        System.out.printf("N[%d] = %.4f%n", 0, array[0]);
        for (int j = 1; j < 100; j++) {
            array[j] = array[j - 1] / 2;
            System.out.printf("N[%d] = %.4f%n", j, array[j]);
        }
    }
}
