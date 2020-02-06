import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] matrix;
        while (N > 0){
            matrix = new int[N][N];

            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix.length; cols++) {
                    matrix[rows][cols] = 1;
                }
            }

            for (int m = 0; m < matrix.length; m++) {
                System.out.printf("%d ", matrix[m][0]);
                for (int n = 1; n < matrix.length - 1; n++){
                    System.out.printf("%3d ", matrix[m][n]);
                }
                System.out.printf("%3d%n", matrix[m][matrix.length - 1]);
            }
            System.out.println();
            N = scanner.nextInt();
        }
    }
}
