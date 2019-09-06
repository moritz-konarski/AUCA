import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] M = new double[12][12];
        int column = scanner.nextInt();
        String operation = scanner.next();
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 12; j++) {
                M[i][j] = scanner.nextDouble();
            }
        }
        double result = 0;
        for (int k = 0; k < 12; k++) {
            result += M[k][column];
        }
        if (operation.equals("S")){
            System.out.printf("%.1f%n", result);
        }else if (operation.equals("M")){
            System.out.printf("%.1f%n", result / 12);
        }
    }
}
