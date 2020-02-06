import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();
        if (A + B > C && A + C > B && C + B > A) //checking if we can make a triangle
        {
            double perimeter = A + B + C;
            System.out.printf("Perimetro = %.1f\n", perimeter); //calculating the perimeter
        }
        else
        {
            double area = (A + B) / 2.0 * C;
            System.out.printf("Area = %.1f\n", area); //calculating the perimeter
        }
    }
}
//a program either calculates the perimeter of a triangle or the area of a trapezoid