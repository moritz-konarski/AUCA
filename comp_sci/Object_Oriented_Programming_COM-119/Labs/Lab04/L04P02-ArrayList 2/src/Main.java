import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intList = new ArrayList<>();
        int i;
        while (scanner.hasNext()) {
            i = scanner.nextInt();
            if (i % 2 == 0)
                intList.add(0);
            intList.add(i);
        }
        System.out.println("After insertions:");
        intList.forEach((n) -> System.out.print(n + " "));
        System.out.println();
        intList.removeIf(n -> (n % 2 == 1));
        System.out.println("After deletions:");
        intList.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
