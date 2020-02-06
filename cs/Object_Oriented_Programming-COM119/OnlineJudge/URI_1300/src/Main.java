import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println((scanner.nextInt() % 6 == 0) ? "Y" : "N");
        }
    }
}
