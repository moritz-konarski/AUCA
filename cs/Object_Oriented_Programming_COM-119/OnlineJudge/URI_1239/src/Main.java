import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int iCount = 0, bCount = 0;
        while (scanner.hasNext()) {
            iCount = bCount = 0;
            if ((input = scanner.nextLine()).equals("")) {
                input = scanner.nextLine();
            }
            while (input.matches(".*[*].*|.*_.*")) {
                if (iCount % 2 == 0) {
                    input = input.replaceFirst("_", "<i>");
                } else {
                    input = input.replaceFirst("_", "</i>");
                }
                iCount++;
                if (bCount % 2 == 0) {
                    input = input.replaceFirst("[*]", "<b>");
                } else {
                    input = input.replaceFirst("[*]", "</b>");
                }
                bCount++;
            }
            System.out.println(input);
        }
    }
}
