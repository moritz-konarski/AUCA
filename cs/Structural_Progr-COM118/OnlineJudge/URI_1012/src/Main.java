import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        System.out.printf("TRIANGULO: %.3f\n", A * C / 2.0 );
        System.out.printf("CIRCULO: %.3f\n", C * C * 3.14159 );
        System.out.printf("TRAPEZIO: %.3f\n", (A + B) / 2.0 * C );
        System.out.printf("QUADRADO: %.3f\n", B * B );
        System.out.printf("RETANGULO: %.3f\n", A * B );
    }
}
//a program that computes the areas of different geometric shapes