import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nScores = new int[101];
        int n = 0;
        System.out.print("Please enter scores from 0 t0 100: ");
        while ((n = scanner.nextInt()) >= 0){
            nScores[n]++;
        }
        int sum = 0;
        int scores = 0;
        int aboveAvrg = 0;
        int belowAvrg = 0;
        for (int i = 0; i < nScores.length; i++){
            if (nScores[i] != 0) {
                sum += nScores[i] * i;
                scores += nScores[i];
            }
        }
        double average = (double) sum / scores;
        for (int j = 0; j < nScores.length; j++){
            aboveAvrg = (nScores[j] != 0 && j > average) ? aboveAvrg + nScores[j]: aboveAvrg;
            belowAvrg = (nScores[j] != 0 && j < average) ? belowAvrg + nScores[j] : belowAvrg;
        }
        System.out.printf("Out of %d scores, the average is %.1f%n" +
                          "%d are below and %d are above average.",
                          scores, average, belowAvrg, aboveAvrg);
    }
}
