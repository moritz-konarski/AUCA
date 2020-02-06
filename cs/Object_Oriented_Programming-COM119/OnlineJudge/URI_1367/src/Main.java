import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int submissions, correctProblems, incorrectProblems, totalTime;
        String lastProblem = "";
        String[] partsOfLine;
        while ((submissions = scanner.nextInt()) != 0) {
            scanner.nextLine();
            correctProblems = incorrectProblems = totalTime = 0;
            for (int i = 0; i < submissions; i++) {
                partsOfLine = scanner.nextLine().trim().split(" ");
                if (!partsOfLine[0].equals(lastProblem))
                    incorrectProblems = 0;
                if (partsOfLine[2].equals("incorrect")) {
                    incorrectProblems++;
                } else if (partsOfLine[2].equals("correct")) {
                    totalTime += Integer.parseInt(partsOfLine[1]) + 20 * incorrectProblems;
                    correctProblems++;
                }
                lastProblem = partsOfLine[0];
            }
            System.out.printf("%d %d%n", correctProblems, totalTime);
        }
    }
}
