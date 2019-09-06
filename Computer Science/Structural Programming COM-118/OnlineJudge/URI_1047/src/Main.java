import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int startHour = scanner.nextInt();
        int startMinute = scanner.nextInt();
        int endHour = scanner.nextInt();
        int endMinute = scanner.nextInt();
        int startTime = startHour * 60 + startMinute;
        int endTime = endHour * 60 + endMinute;
        int totalTime = 0;
        int finalHours = 0;
        int finalMinutes = 0;

        if (endTime < startTime){
            totalTime = endTime + (24 * 60 - startTime);
        }
        else if (endTime > startTime){
            totalTime = endTime - startTime;
        }
        else {
            totalTime = 24 * 60;
        }
        finalMinutes = (totalTime % 60);
        finalHours = (totalTime - finalMinutes) / 60;
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", finalHours, finalMinutes);
    }
}
// a program that computes the length of time based on hours and minutes of start and finish