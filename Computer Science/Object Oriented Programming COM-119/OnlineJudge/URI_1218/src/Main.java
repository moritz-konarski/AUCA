import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String givenSize;
        String[] pairsOfShoes;
        int total, masculine, feminine, testCase = 0;
        while (scanner.hasNext()) {
            if (testCase > 0) {
                System.out.println();
            }
            testCase++;
            total = masculine = feminine = 0;
            givenSize = scanner.nextLine().trim();
            pairsOfShoes = scanner.nextLine().trim().split(" (?![A-Z])");
            for(String pair : pairsOfShoes) {
                if (pair.matches(givenSize + " F")) {
                    feminine++;
                    total++;
                } else if (pair.matches(givenSize + " M")) {
                    masculine++;
                    total++;
                }
            }
            System.out.printf("Caso %d:%nPares Iguais: %d%nF: %d%nM: %d%n", testCase, total, feminine, masculine);
        }
    }
}
