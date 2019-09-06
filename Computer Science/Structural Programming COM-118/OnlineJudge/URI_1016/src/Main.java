import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        int timeToMeet = distance * 2;
        System.out.println(timeToMeet + " minutos");
    }
}
//a program that computes the time it takes for a car to catch up to another one