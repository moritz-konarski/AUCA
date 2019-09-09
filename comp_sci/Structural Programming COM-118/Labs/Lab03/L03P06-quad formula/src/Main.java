import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();
        double underTheRoot = Math.pow(B, 2) - 4 * A * C;
        if (A == 0 || underTheRoot < 0){System.out.println("The equation has no real roots.");}
        double R1 = (-B + Math.sqrt(underTheRoot))/(2 * A);
        double R2 = (-B - Math.sqrt(underTheRoot))/(2 * A);
        if (underTheRoot == 0)
        {
            System.out.printf("The equation has one root %.3f\n", R1);
        }
        else {
            System.out.printf("The equation has two roots %.3f and %.3f\n", R1, R2);
        }


    }
}
//a program that computes the routes of a quadratic equation ax^2 + bx + c = y