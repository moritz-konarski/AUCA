import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), a, b;
        for (int i = 0; i < iterations; i++) {
            StringBuilder output = new StringBuilder();
            a = scanner.nextInt();
            b = scanner.nextInt();
            for (; a <= b; a++)
                output.append(a);
            System.out.print(output);
            System.out.println(output.reverse());
        }
    }
}