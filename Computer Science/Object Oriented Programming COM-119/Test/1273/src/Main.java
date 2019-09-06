import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), maxLength;
        String output;
        String[] input;
        while (true) {
            maxLength = 0;
            input = new String[n];
            for (int i = 0; i < input.length; i++) {
                input[i] = sc.next();
                maxLength = (input[i].length() > maxLength) ? input[i].length() : maxLength;
            }
            output = ("%" + maxLength + "s%n");
            for (String string : input) {
                System.out.printf(output, string);
            }
            if ((n = sc.nextInt()) == 0)
                break;
            System.out.println();
        }
    }
}