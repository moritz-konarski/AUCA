import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> sheep;
        int iterations= scanner.nextInt(), nSheep, input;
        for (int i = 0; i < iterations; i++) {
            sheep = new ArrayList<>();
            nSheep = scanner.nextInt();
            for (int j = 0; j < nSheep; j++) {
                input = scanner.nextInt();
                if (!sheep.contains(input)) {
                    sheep.add(input);
                }
            }
            System.out.println(sheep.size());
        }

    }
}
