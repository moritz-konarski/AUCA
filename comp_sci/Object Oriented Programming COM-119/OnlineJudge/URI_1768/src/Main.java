import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int asterisks = 0;
        while (scanner.hasNext()) {
            asterisks = scanner.nextInt();
            for (int i = 1; i <= asterisks; i += 2) {
                for (int j = 0; j < (asterisks - i) / 2; j++)
                    System.out.print(" ");
                for (int k = 0; k < i; k++)
                    System.out.print("*");
                System.out.println();
            }
            for (int i = 1; i <= 3; i += 2) {
                for (int j = 0; j < (asterisks - i) / 2; j++)
                    System.out.print(" ");
                for (int k = 0; k < i; k++)
                    System.out.print("*");
                System.out.println();
            }
            System.out.println();
        }
    }
}
