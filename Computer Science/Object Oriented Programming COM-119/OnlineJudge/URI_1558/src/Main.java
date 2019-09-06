import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        String out;
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            squares.add(i * i);
        }
        while (scanner.hasNext()) {
            out = "NO";
            input = scanner.nextInt();
            for (int i : squares) {
                if (squares.contains(input - i)) {
                    out = "YES";
                    break;
                }
            }
            System.out.println(out);
        }
    }
}
