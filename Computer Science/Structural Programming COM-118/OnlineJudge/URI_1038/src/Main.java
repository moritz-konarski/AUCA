import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double[] priceArray = new double[]{4.0, 4.5, 5.0, 2.0, 1.5};
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        System.out.printf("Total: R$ %.2f\n", priceArray[X-1] * Y);
    }
}
//a program that outputs the total cost given item number and count