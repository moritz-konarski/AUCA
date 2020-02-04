import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float X = scanner.nextFloat();
        float Y = scanner.nextFloat();
        double threshold = 1e-5;

        if (X > 0 && Y > 0)
        {
            System.out.println("Q1");
        }
        else if (X < 0 && Y > 0)
        {
            System.out.println("Q2");
        }
        else if (X < 0 && Y < 0)
        {
            System.out.println("Q3");
        }
        else if (X > 0 && Y < 0)
        {
            System.out.println("Q4");
        }
        else if (Math.abs(X) < threshold && Y != 0)
        {
            System.out.println("Eixo X");
        }
        else if (X != 0 && Math.abs(Y) < threshold)
        {
            System.out.println("Eixo Y");
        }
        else
        {
            System.out.println("Origem");
        }
    }
}
//a program that takes two coordinates and then tells you which quadrant the point is in and if it is at the origin or on one of the axes