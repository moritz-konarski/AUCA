import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double average = (3.5 * A + 7.5 * B)/11;
        System.out.printf("MEDIA = %.5f\n", average);
    }
}
//program that takes two doubles and prints the weighted average of the two in a format the oj wants