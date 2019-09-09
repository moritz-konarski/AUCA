import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int charsPerLine, linesPerPage;
        int charCount, nLines, space;
        String[] story;
        while (scanner.hasNext()) {
            charCount = space = 0;
            nLines = 1;
            scanner.nextInt();
            linesPerPage = scanner.nextInt();
            charsPerLine = scanner.nextInt();
            scanner.nextLine();
            story = scanner.nextLine().trim().split(" ");
            for (String word : story) {
                if ((charCount += word.length() + space) > charsPerLine) {
                    charCount = word.length();
                    nLines++;
                }
                space = 1;
            }
            System.out.println((int) Math.ceil(1.0 * nLines / linesPerPage));
        }
    }
}
