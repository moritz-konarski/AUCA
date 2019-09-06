import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence;
        int charcode, counter;
        char[] chars;
        while (!(sentence = scanner.nextLine()).equals("")) {
            chars = sentence.toCharArray();
            counter = 0;
            for (int j = 0; j < chars.length; j++) {
                charcode = (int) chars[j];
                if (charcode >= 65 && charcode <= 90 || charcode >= 97 && charcode <= 122) {
                    counter++;
                    if (counter % 2 == 0) {
                        charcode = (charcode >= 90) ? chars[j] : chars[j] + 32;      //making lower case
                    } else {
                        charcode = (charcode >= 90) ? chars[j] - 32 : chars[j];      //making upper case
                    }
                }
                chars[j] = (char) charcode;
            }
            sentence = new String(chars);
            System.out.println(sentence);
        }
    }
}
