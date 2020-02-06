import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter side A of the triangle: ");
        double A = scanner.nextDouble();
        System.out.print("Please enter side B of the triangle: ");
        double B = scanner.nextDouble();
        System.out.print("Please enter side C of the triangle: ");
        double C = scanner.nextDouble();
        double perimeter = 0;
        boolean positiveSides = (A > 0 && B > 0 && C > 0);
        if (A + B > C && B + C > A && A + C > B && positiveSides){
            perimeter = A + B + C;
            System.out.printf("A triangle with the sides A = %.1f; B = %.1f; C = %.1f has the perimeter p = %.1f", A, B, C, perimeter);
        }
        else {
            System.err.println("The sides do not form a triangle. Please enter correct side lenghts.");
            System.exit(-1);
        }
    }
}
