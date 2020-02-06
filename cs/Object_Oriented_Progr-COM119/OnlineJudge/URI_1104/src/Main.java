import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nAlice, nBetty, input;
        ArrayList<Integer> alice, betty;
        while ((nAlice = scanner.nextInt()) + (nBetty = scanner.nextInt()) > 0) {
            alice = new ArrayList<>();
            betty = new ArrayList<>();
            for (int i = 0; i < nAlice; i++) {
                input = scanner.nextInt();
                if (!alice.contains(input)) {
                    alice.add(input);
                }
            }
            for (int j = 0; j < nBetty; j++) {
                input = scanner.nextInt();
                if (!alice.contains(input) && !betty.contains(input)) {
                    betty.add(input);
                }
            }
            System.out.println(betty.size() > alice.size() ? alice.size() : betty.size());
        }
    }
}
