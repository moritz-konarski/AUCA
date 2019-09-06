import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), max;
        String format;
        String[] lines;
        while (iterations != 0){
            lines = new String[iterations];
            max = 0;
            for (int i = 0; i < iterations; i++){
                lines[i] = scanner.next().trim();
                max = (lines[i].length() > max) ? lines[i].length() : max;
            }
            format = "%" + max + "s%n";
            for (String line : lines){
                System.out.printf(format, line);
            }
            if ((iterations = scanner.nextInt()) == 0)
                break;
            System.out.println();
        }
    }
}
