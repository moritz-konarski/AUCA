import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of minutes: ");
        final double MIN_PER_YEAR = 365 * 24 * 60;
        final double MIN_PER_DAY = 24 * 60;
        double minutes = scanner.nextDouble();
        double days = (minutes % MIN_PER_YEAR) / MIN_PER_DAY;
        double years = (minutes - minutes % MIN_PER_YEAR) / MIN_PER_YEAR;
        System.out.printf("%.0f minutes is approximately %.0f years and %.0f days", minutes, years, days);
    }
}