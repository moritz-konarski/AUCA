import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = 0;
        int x = 0;

        while (true){
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (x < y) {
                System.out.println("Crescente");
            }
            else if (y < x){
                System.out.println("Decrescente");
            }
            else {
                break;
            }
        }
    }
}
