import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();
        double average = (2.0 * A + 3.0 * B + 5.0 * C)/10;
        System.out.printf("MEDIA = %.1f\n", average);
    }
}
//a program that computes the weighted average of three variables