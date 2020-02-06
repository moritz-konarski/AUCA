import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        int[][] points;
        int[] robot;
        for (int i = 0; i < iterations; i++) {
            points = new int[4][2];
            robot = new int[2];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    points[j][k] = scanner.nextInt();
                }
            }
            robot[0] = scanner.nextInt();
            robot[1] = scanner.nextInt();
            if (robot[0] >= points[0][0] && robot[0] <= points[2][0] && robot[1] >= points[0][1] && robot[1] <= points[2][1]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
