import java.util.Scanner;

public class Main {

    public static boolean checkRows(int[][] sudoku) {
        boolean rowsCorrect = true;
        boolean[][] numberUsed = new boolean[9][9];
        for (int j = 0; j < sudoku[0].length; j++) {
            for (int i = 0; i < sudoku.length; i++) {
                numberUsed[j][sudoku[i][j] - 1] ^= true;   //xor that flips the value of the boolean corresponding to the number
            }
        }
        for (int m = 0; m < numberUsed.length; m++) {
            for (int k = 0; k < numberUsed.length; k++) {
                rowsCorrect &= numberUsed[m][k];
            }
        }
        return rowsCorrect;
    }

    public static boolean checkCols(int[][] sudoku) {
        boolean colsCorrect = true;
        boolean[][] numberUsed = new boolean[9][9];
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                numberUsed[i][sudoku[i][j] - 1] ^= true;   //xor that flips the value of the boolean corresponding to the number
            }
        }
        for (int m = 0; m < numberUsed.length; m++) {
            for (int k = 0; k < numberUsed.length; k++) {
                colsCorrect &= numberUsed[m][k];
            }
        }
        return colsCorrect;
    }

    public static boolean checkBoxes(int[][] sudoku) {
        boolean boxesCorrect = true;
        boolean[] boxCorrect = new boolean[9];
        boolean[][] numberUsed = new boolean[9][9];
        for (int m = 0; m < sudoku.length; m++) {
            //check a box
            for (int i = m / 3; i < m / 3 + 3; i++) {         //rows, goes down every three iteration of m
                for (int j = m % 3; j < m % 3 + 3; j++) {  //cols, moves every m
                    numberUsed[m][sudoku[i][j] - 1] ^= true;   //xor that flips the value of the number
                }
            }
            //check the box
            for (int n = 0; n < sudoku.length; n++) {
                boxCorrect[m] |= numberUsed[m][n];
            }
        }
        for (int k = 0; k < numberUsed.length; k++) {
            boxesCorrect &= boxCorrect[k];
        }
        return boxesCorrect;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        System.out.println("Please enter a Sudoku solution:");
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                sudoku[i][j] = scanner.nextInt();
            }
        }
        if (checkRows(sudoku) && checkCols(sudoku) && checkBoxes(sudoku)) {
            System.out.println("Valid Solution.");
        } else {
            System.out.println("Invalid Solution.");
        }
    }
}
