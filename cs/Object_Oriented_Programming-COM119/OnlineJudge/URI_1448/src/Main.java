import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        scanner.nextLine();
        int pointsTeam1, pointsTeam2;
        String result;
        String[] message, team1, team2;
        for (int i = 1; i <= iterations; i++) {
            pointsTeam1 = pointsTeam2 = 0;
            result = "empate";
            message = scanner.nextLine().split("");
            team1 = scanner.nextLine().split("");
            team2 = scanner.nextLine().split("");
            for (int j = 0; j < message.length; j++) {
                if (team1[j].equals(message[j]))
                    pointsTeam1++;
                if (team2[j].equals(message[j]))
                    pointsTeam2++;
            }
            if (pointsTeam1 != pointsTeam2) {
                result = (pointsTeam1 > pointsTeam2) ? "time 1" : "time 2";
            } else {
                for (int j = 0; j < message.length; j++) {
                    if (!team1[j].equals(message[j]) && !team2[j].equals(message[j])) {
                        break;
                    }
                    if (!team1[j].equals(message[j])) {
                        result = "time 2";
                        break;
                    }
                    if (!team2[j].equals(message[j])) {
                        result = "time 1";
                        break;
                    }
                }
            }
            System.out.printf("Instancia %d%n%s%n%n", i, result);
        }
    }
}
