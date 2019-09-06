import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        //the beginning of the first batch of data
        scanner.skip("Dia ");
        int startDay = scanner.nextInt();
        int startHour = scanner.nextInt();
        scanner.skip(" : ");
        int startMinute = scanner.nextInt();
        scanner.skip(" : ");
        int startSecond = scanner.nextInt();
        //the beginning of the second batch of data
        scanner.skip("\nDia ");
        int endDay = scanner.nextInt();
        int endHour = scanner.nextInt();
        scanner.skip(" : ");
        int endMinute = scanner.nextInt();
        scanner.skip(" : ");
        int endSecond = scanner.nextInt();

        int startTime = startSecond + startMinute *60 + startHour * 3600 + startDay * 24 *3600;
        int endTime = endSecond + endMinute *60 + endHour * 3600 + endDay * 24 *3600;

        int duration = endTime - startTime;

        int durationDays = duration / (24 * 3600);
        int durationHour = (duration - durationDays * 24 * 3600) / (3600);
        int durationMin = (duration - durationDays * 24 * 3600 - durationHour * 3600) / 60;
        int durationSec = duration % 60;

        System.out.println(durationDays + " dia(s)");
        System.out.println(durationHour + " hora(s)");
        System.out.println(durationMin + " minuto(s)");
        System.out.println(durationSec + " segundo(s)");
    }
}
