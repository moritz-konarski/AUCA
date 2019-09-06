import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length in inches: ");
        double inches = scanner.nextDouble();
        double centimeters = inches * 2.54;
        System.out.printf("%.2f in. = %.2f cm.", inches, centimeters);
    }
}