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
        if (A == 0 || underTheRoot < 0){System.out.println("Impossivel calcular");}
        else
        {
            double R1 = (-B + Math.sqrt(underTheRoot))/(2 * A);
            double R2 = (-B - Math.sqrt(underTheRoot))/(2 * A);
            System.out.printf("R1 = %.5f\nR2 = %.5f\n", R1, R2);
        }


    }
}
//a program that compares the routes of a quadratic equation ax^2 + bx + c = y