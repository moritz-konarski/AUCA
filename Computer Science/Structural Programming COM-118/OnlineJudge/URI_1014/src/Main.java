import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        float Y = scanner.nextFloat();
        float avrg_consumption = X/Y;
        System.out.printf("%.3f km/l\n", avrg_consumption);
    }
}
//a program that computes the gas mileage given the distance and fuel consumption