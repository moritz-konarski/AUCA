import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double A = Math.max(Math.max(a, b), c);
        double C = Math.min(Math.min(a, b), c);
        double B = (a + b + c) - (A + C);

        if (A >= B + C)
        {
            System.out.println("NAO FORMA TRIANGULO");
        }
        else {
            if (A * A == B * B + C * C) {
                System.out.println("TRIANGULO RETANGULO");
            }
            if (A * A > B * B + C * C) {
                System.out.println("TRIANGULO OBTUSANGULO");
            }
            if (A * A < B * B + C * C) {
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if (a == b && b == c) {
                System.out.println("TRIANGULO EQUILATERO");
            }
            if ((a == b && b != c) || (a == c && b != c) || (c == b && b != a)) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
}
//a program that checks which kind of triangles three side lenghts can make