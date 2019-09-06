import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the dimension of the multiplication table (number of rows): ");
        int rows = scanner.nextInt();

        System.out.println("     A Multiplication table from 1 until " + rows);
        System.out.print("    |");
        for (int k = 1; k <= 10; k++){
            System.out.printf("%4d", k);
        }
        System.out.println("\n--------------------------------------------");

        for (int i = 1; i <= rows; i++){
            System.out.printf("%3d |", i);
            for (int j = 1; j <= 10; j++){
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
