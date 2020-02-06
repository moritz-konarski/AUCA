import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][4];
        int sum = 0;
        System.out.println("Please enter 3 rows and 4 columns:");
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                array[i][j]=scanner.nextInt();
                sum += array[i][j];
            }
        }
        System.out.printf("The sum of all elements is %d.", sum);
    }
}