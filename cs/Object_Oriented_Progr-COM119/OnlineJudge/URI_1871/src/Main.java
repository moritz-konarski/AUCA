import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt(), result;
        String output;
        while (m != 0 && n != 0) {
            result = n + m;
            output = Integer.toString(result);
            System.out.println(output.replaceAll("0", ""));
            m = scanner.nextInt();
            n = scanner.nextInt();
        }
    }
}
