import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int m, n;
        for (int x = 0; x < testCases; x++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int places = (int) (m * Math.log10(n)) + 1;
            System.out.println(places);
        }
    }
}
