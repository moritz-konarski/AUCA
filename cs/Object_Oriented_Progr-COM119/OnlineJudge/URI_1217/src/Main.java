import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        double averagePrice = 0;
        int[] fruitPerDay = new int[iterations];
        for (int i = 0; i < iterations; i++) {
            averagePrice += scanner.nextDouble() / iterations;
            scanner.nextLine();
            String line = scanner.nextLine();
            fruitPerDay[i] = line.split(" ").length;
            System.out.printf("day %d: %d kg%n", i + 1, fruitPerDay[i]);
        }
        double averageWeight = 0;
        for (int day : fruitPerDay) {
            averageWeight += 1.0 * day / iterations;
        }
        System.out.printf("%.2f kg by day%nR$ %.2f by day%n", averageWeight, averagePrice);
    }
}
