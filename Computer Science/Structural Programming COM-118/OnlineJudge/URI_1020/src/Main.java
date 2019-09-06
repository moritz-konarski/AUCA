import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int totalDays = scanner.nextInt();

        int rest = totalDays % 365;
        int years = (totalDays - rest) / 365;
        totalDays = rest;

        rest = totalDays% 30;
        int months = (totalDays - rest) / 30;

        int days = rest;

        System.out.println(years + " ano(s)\n"  + months + " mes(es)\n" + days + " dia(s)");
    }
}
//a program that converts a number of days into years, months and days