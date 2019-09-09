import java.util.Scanner;
public class Main {

    public static void displayPattern(int n){
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = - j + i + 1;
            }
        }
        String space;
        for (int k = 0; k < matrix.length; k++){
            for (int b = 0; b < matrix.length - k - 1; b++) {
                space = (matrix[n - 1][b] > 9) ? "   " : "  ";
                System.out.print(space);
            }
            for (int m = 0; m < matrix.length; m++){
                if (matrix[k][m] > 0) {
                    System.out.printf(" %d", matrix[k][m]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer for the pattern: ");
        int n = scanner.nextInt();
        displayPattern(n);
    }
}
