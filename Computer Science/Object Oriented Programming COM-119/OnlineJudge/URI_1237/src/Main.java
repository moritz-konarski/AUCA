import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder substring, superString, testString;
        int wordLength;
        boolean finished;
        while (scanner.hasNext()) {
            wordLength = 0;
            finished = false;
            superString.equals(scanner.nextLine().trim().t);
            substring = scanner.nextLine().trim();
            for (int length = 1; length < substring.length(); length++) {
                for (int offset = 0; offset < substring.length() - length; offset++) {
                    testString = "(.*)(" + substring.substring(offset, length + offset) + ")(.*)";
                    if (superString.matches(substring.replace(testString, "$1$3")) && !testString.equals("")) {
                        wordLength = testString.length();
                        finished = true;
                        break;
                    }
                    if (finished) {
                        break;
                    }
//                    testString = substring.replace(testString, "");
//                    if (superString.contains(testString) && !testString.equals("")) {
//                        wordLength = testString.length();
//                        finished = true;
//                        break;
//                    }
                }
            }
            System.out.print(testString);
            System.out.println(wordLength);
        }
    }
}
