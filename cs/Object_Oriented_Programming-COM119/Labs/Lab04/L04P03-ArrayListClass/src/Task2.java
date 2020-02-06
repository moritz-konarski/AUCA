import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayListIntV2 list = new ArrayListIntV2();
        int i, start = 0;
        try {
            while (scanner.hasNext()) {
                i = scanner.nextInt();
                if (i % 2 == 0)
                    list.add(0);
                list.add(i);
            }
            System.out.printf("After insertions:%n%s%n", list.toString());
            while (start < list.size()) {
                for (int j = start; j < list.size(); j++) {
                    if (list.get(j) % 2 == 1) {
                        list.remove(j);
                        start = j;
                        break;
                    }
                    if (j == list.size() - 1)
                        start = j + 1;
                }
            }
            System.out.printf("After reversing:%n%s%n", list.toString());
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
