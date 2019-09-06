import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        if (A < 0 || A > 100){System.out.println("Fora de intervalo");}
        else if (0 <= A && A <= 25)
        {
            System.out.println("Intervalo [0,25]");
        }
        else if (25 < A && A <= 50)
        {
            System.out.println("Intervalo (25,50]");
        }
        else if (50 < A && A <= 75)
        {
            System.out.println("Intervalo (50,75]");
        }
        else
        {
            System.out.println("Intervalo (75,100]");
        }
    }
}
//a program that compares sorts numbers into brakes along the number line