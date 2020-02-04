import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nRegions, m;
        while ((nRegions = scanner.nextInt()) != 0) {
            if (nRegions == 13) {
                m = 1;
            } else {
                m = 2;
                while (getLast(nRegions, m) != 11)
                    m++;
            }
            System.out.println(m);
        }
    }

    private static int getLast(int n, int m) {
        int index = 0;
        for (int i = 1; i < n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}
