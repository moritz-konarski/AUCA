import java.util.Scanner;

public class Main {

    public static void buildMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 2;
                } else if (i == n - 1 - j) {
                    matrix[i][j] = 3;
                }
                if (i >= n / 3 && j >= n / 3 && i < n - n / 3 && j < n - n / 3) {
                    matrix[i][j] = 1;
                }
            }
        }
        matrix[n / 2][n / 2] = 4;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int[][] matrix;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            matrix = new int[n][n];
            buildMatrix(matrix);
            printMatrix(matrix);
        }
    }
}
