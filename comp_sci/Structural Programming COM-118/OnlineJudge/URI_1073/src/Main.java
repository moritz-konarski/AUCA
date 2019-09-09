import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int square = 0;
        for (int i = 1; i <= number; i++){

            if (i % 2 == 0){
                square = i * i;
                System.out.printf("%d^2 = %d\n", i, square);
            }
        }

    }
}
