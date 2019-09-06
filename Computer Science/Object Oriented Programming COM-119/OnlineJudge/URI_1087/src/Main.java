import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1, y1, x2, y2, moves;
        x1 = scanner.nextInt();
        y1 = scanner.nextInt();
        x2 = scanner.nextInt();
        y2 = scanner.nextInt();
        while (x1 + y1 + x2 + y2 > 0) {
            if (x1 == x2 && y1 == y2) {
                moves = 0;
            } else if (x1 == x2 || y1 == y2 || (Math.abs(x1 - x2) == Math.abs(y1 - y2))) {
                moves = 1;
            } else {
                moves = 2;
            }
            System.out.println(moves);
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
        }
    }
}
