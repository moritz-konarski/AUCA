import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nProblems, nContestants, input;
        int[] contestant, problem;
        while ((nContestants = scanner.nextInt()) + (nProblems = scanner.nextInt()) > 0) {
            contestant = new int[nContestants];
            problem = new int[nProblems];
            for (int nthcontestant = 0; nthcontestant < nContestants; nthcontestant++) {
                for (int nthProblme = 0; nthProblme < nProblems; nthProblme++) {
                    input = scanner.nextInt();
                    contestant[nthcontestant] += input;
                    problem[nthProblme] += input;
                }
            }
            Arrays.sort(contestant);
            Arrays.sort(problem);
            input = 0;
            if (Arrays.binarySearch(contestant, 0) < 0) {
                input++;
            }
            if (Arrays.binarySearch(problem, 0) < 0) {
                input++;
            }
            if (Arrays.binarySearch(contestant, nProblems) < 0) {
                input++;
            }
            if (Arrays.binarySearch(problem, nContestants) < 0) {
                input++;
            }
            System.out.println(input);
        }
    }
}
