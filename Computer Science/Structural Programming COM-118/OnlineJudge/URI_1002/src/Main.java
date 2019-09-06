import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double R = scanner.nextDouble();
        final double PI = 3.14159;
        double A = PI * R * R;
        System.out.printf("A=%.4f\n", A);
    }
}
//program that takes a radius and prints the area of the circle to four decimal places