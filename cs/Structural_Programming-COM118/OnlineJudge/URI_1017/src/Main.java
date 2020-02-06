import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final double efficiency = 1/12.0;
        int time = scanner.nextInt();
        int avrgSpeed = scanner.nextInt();
        double neededFuel = time * avrgSpeed * efficiency;
        System.out.printf("%.3f\n", neededFuel);
    }
}
//a program that computes the amount of fuel needed to travel a distance at an average speed