import java.util.Scanner;

public class Main {

    public static double[][] matrixMultiply(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {                //each row of the result matrix
            for (int j = 0; j < 3; j++) {            //each column of the result matrix
                result[i][j] = matrix1[i][0] * matrix2[0][j] +          //a11 * b11
                               matrix1[i][1] * matrix2[1][j] +          //a12 * b21
                               matrix1[i][2] * matrix2[2][j];           //a13 * b31
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix1 = new double[3][3];
        double[][] matrix2 = new double[3][3];
        System.out.print("Enter the first matrix: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }
        System.out.print("Enter the second matrix: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }
        double[][] result = matrixMultiply(matrix1, matrix2);
        for (int k = 0; k < 3; k++) {
            //first matrix
            System.out.printf("|%5.1f %5.1f %5.1f|", matrix1[k][0], matrix1[k][1], matrix1[k][2]);
            if (k == 1){
                System.out.print("  X  ");
            }
            else{
                System.out.print("     ");
            }
            System.out.printf("|%5.1f %5.1f %5.1f|", matrix2[k][0], matrix2[k][1], matrix2[k][2]);
            if (k == 1){
                System.out.print("  =  ");
            }
            else{
                System.out.print("     ");
            }
            System.out.printf("|%5.1f %5.1f %5.1f|%n", result[k][0], result[k][1], result[k][2]);
        }
    }
}
