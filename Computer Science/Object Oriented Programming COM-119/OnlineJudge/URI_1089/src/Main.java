import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSamples, nPeaks;
        int[] p;

        while ((nSamples = scanner.nextInt()) != 0) {
            p = new int[nSamples];
            nPeaks = 0;
            for (int i = 0; i < nSamples; i++) {
                p[i] = scanner.nextInt();
            }
            for (int j = 0; j < nSamples; j++) {
                if (p[j] > p[getIndex(j - 1, nSamples)] && p[j] > p[getIndex(j + 1, nSamples)])
                    nPeaks++;
                else if (p[j] < p[getIndex(j - 1, nSamples)] && p[j] < p[getIndex(j + 1, nSamples)])
                    nPeaks++;
            }
            System.out.println(nPeaks);
        }
    }

    private static int getIndex(int index, int length) {
        if (index >= 0) {
            return (index) % length;
        } else {
            return length - 1;
        }
    }
}
