import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int winsJohn, winsMary, nGames;
        while ((nGames = scanner.nextInt()) != 0) {
            winsJohn = winsMary = 0;
            for (int i = 0; i < nGames; i++) {
                if (scanner.nextInt() == 0) {
                    winsMary++;
                } else {
                    winsJohn++;
                }
            }
            System.out.printf("Mary won %d times and John won %d times%n", winsMary, winsJohn);
        }
    }
}
