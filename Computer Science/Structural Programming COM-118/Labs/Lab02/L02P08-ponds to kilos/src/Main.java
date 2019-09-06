import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number in pounds: ");
        double pounds = scanner.nextDouble();
        double kilos = pounds * 0.454;
        System.out.printf("%.1f pounds is %.3f kilograms", pounds, kilos);
    }
}