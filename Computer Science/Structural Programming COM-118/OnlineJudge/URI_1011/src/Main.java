import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        final double pi = 3.14159;
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double volume = (4/3.0)*pi*Math.pow(radius, 3);
        System.out.printf("VOLUME = %.3f\n", volume);
    }
}
//a program that computes the volume of a sphere given its radius