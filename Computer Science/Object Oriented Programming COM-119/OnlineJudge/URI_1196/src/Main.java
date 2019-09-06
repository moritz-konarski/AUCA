import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String kb = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        int index;
        while (scanner.hasNext()) {
            char[] line = scanner.nextLine().toCharArray();
            for (char c : line) {
                index = kb.indexOf(c);
                System.out.print((index != -1) ? kb.charAt(index - 1) : c);
            }
            System.out.println();
        }
    }
}
