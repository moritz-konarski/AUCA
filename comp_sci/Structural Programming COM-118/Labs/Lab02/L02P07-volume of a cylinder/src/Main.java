import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius and length of a cylinder: ");
        double radius = scanner.nextDouble();
        double height = scanner.nextDouble();
        double areaOfCircle = radius * radius * Math.PI;
        double volumeOfCylinder = areaOfCircle * height;
        System.out.printf("The are is %.4f\nThe volume is %.1f", areaOfCircle, volumeOfCylinder);
    }
}