import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        x = Math.abs(x);
        y = Math.abs(y);
        if (x > 5 || y > 2.5){
            System.out.printf("The point (%.1f, %.1f) is not in the restangle.", x, y);
        }
        else {
            System.out.printf("The point (%.1f, %.1f) is in the restangle.", x, y);
        }
    }
}
