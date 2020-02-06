import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] sudoku, sudoku2;
        int iterations = scanner.nextInt(), input;
        for (int i = 1; i <= iterations; i++) {
            sudoku = new int[9][9];
            sudoku2 = new int[9][9];
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    input = scanner.nextInt();
                    sudoku[row][col] = input;
                    sudoku2[col][row] = input;
                }
            }
            if (rowsOK(sudoku) && rowsOK(sudoku2) && partsOK(sudoku)) {
                System.out.printf("Instancia %d%nSIM%n%n", i);
            } else {
                System.out.printf("Instancia %d%nNAO%n%n", i);
            }
            System.out.printf("%b, %b, %b%n", rowsOK(sudoku), rowsOK(sudoku2), partsOK(sudoku));
        }
    }

    private static boolean rowsOK(int[][] sudoku) {
        for (int[] row : sudoku) {
            if (sliceWrong(row)) {
                return false;
            }
        }
        return true;
    }

    private static boolean partsOK(int[][] sudoku) {
        int[] part;
        int index;
        for (int nPart = 0; nPart < 9; nPart++) {
            part = new int[9];
            index = 0;
            for (int row = nPart / 3; row < nPart / 3 + 3; row++) {
                for (int col = (nPart % 3) * 3; col < (nPart % 3) * 3 + 3; col++) {
                    part[index++] = sudoku[row][col];
                }
            }
            if (sliceWrong(part)) {
                return false;
            }
        }
        return true;
    }

    private static boolean sliceWrong(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i <= 9; i++)
            if (array[i - 1] != i)
                return true;
        return false;
    }
}
