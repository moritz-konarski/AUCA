import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] M = new double[12][12];
        String operation = scanner.next();
        for (int rows = 0; rows < 12; rows++) {
            for (int cols = 0; cols < 12; cols++) {
                M[rows][cols] = scanner.nextDouble();
            }
        }
        double result = 0;
        for (int cols = 0; cols < 12; cols++) {
            for (int rows = cols; rows <  11 - cols; rows--) {
                result += M[rows][cols];
            }
        }
        if (operation.equals("S")) {
            System.out.printf("%.1f%n", result);
        } else if (operation.equals("M")) {
            System.out.printf("%.1f%n", result / (144 / 4 - 6));
        }
    }
}
