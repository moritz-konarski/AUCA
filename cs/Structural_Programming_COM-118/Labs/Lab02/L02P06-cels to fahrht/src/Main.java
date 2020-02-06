import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Temperature in Degrees Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = 9.0/5 * celsius + 32;
        System.out.printf("%.2f Degrees Celsius = %.2f Degrees Fahrenheit", celsius, fahrenheit);
    }
}