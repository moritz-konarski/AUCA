import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayListIntV2 list = new ArrayListIntV2();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        System.out.printf("Before reversing:%n%s%n", list.toString());
        list.reverse();
        System.out.printf("After reversing:%n%s%n", list.toString());
    }
}
