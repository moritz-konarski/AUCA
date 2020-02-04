import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        String rajesh, sheldon, outcome = "sheldon";
        final String paper = "papel", rock = "pedra", scissors = "tesoura", lizard = "lagarto", spock = "spock",
                raj = "rajesh", tie = "empate";
        for (int i = 0; i < iterations; i++) {
            sheldon = scanner.next().trim();
            rajesh = scanner.next().trim();
            if (rajesh.equals(sheldon)) {
                System.out.println(tie);
                continue;
            }
            switch (rajesh) {
                case rock:
                    if (sheldon.equals(lizard) || sheldon.equals(scissors))
                        outcome = raj;
                    break;
                case paper:
                    if (sheldon.equals(spock) || sheldon.equals(rock))
                        outcome = raj;
                    break;
                case scissors:
                    if (sheldon.equals(paper) || sheldon.equals(lizard))
                        outcome = raj;
                    break;
                case lizard:
                    if (sheldon.equals(spock) || sheldon.equals(paper))
                        outcome = raj;
                    break;
                case spock:
                    if (sheldon.equals(scissors) || sheldon.equals(rock))
                        outcome = raj;
                    break;
            }
            System.out.println(outcome);
        }
    }
}
