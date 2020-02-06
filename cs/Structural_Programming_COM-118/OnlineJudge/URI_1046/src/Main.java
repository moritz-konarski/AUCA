import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int startTime = scanner.nextInt();
        int endTime = scanner.nextInt();
        int totalTime = 0;
        if (endTime < startTime){
            totalTime = endTime + (24 - startTime);
        }
        else if (endTime > startTime){
            totalTime = endTime - startTime;
        }
        else {
            totalTime = 24;
        }
        System.out.printf("O JOGO DUROU %d HORA(S)\n", totalTime);
    }
}
//a program that calculates a duration based on start and end time