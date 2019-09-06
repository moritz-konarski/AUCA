import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("some real number ");
        double number = scanner.nextDouble();
        System.out.printf("|%.1f| = %.1f", number, Math.abs(number));
    }
}
