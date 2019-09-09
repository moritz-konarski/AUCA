import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter today's day: ");
        int startDay = scanner.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int endDay = scanner.nextInt();
        int futureWeekDay = (startDay + endDay) % 7;
        String[] weekday = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.printf("Today is %s and the future day is %s", weekday[startDay], weekday[futureWeekDay]);
    }
}
//a program that tells you the day of the week of two days by their number