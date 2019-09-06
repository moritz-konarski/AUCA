import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int totalSeconds = scanner.nextInt();

        int rest = totalSeconds % 3600;
        int hours = (totalSeconds - rest) / 3600;
        totalSeconds = rest;

        rest = totalSeconds % 60;
        int minutes = (totalSeconds - rest) / 60;

        int seconds = rest;

        System.out.println(hours + ":"  + minutes + ":" + seconds);
    }
}
//a program that converts a number of seconds into the format of hh:mm:ss