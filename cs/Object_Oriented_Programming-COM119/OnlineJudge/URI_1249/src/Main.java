import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plaintext, ciphertext;
        char[] plainchars, cipherchars;
        int charcode, cipherkey = 13;
        while (scanner.hasNext()) {
            plaintext = scanner.nextLine();
            plainchars = plaintext.toCharArray();
            cipherchars = new char[plainchars.length];
            for (int i = 0; i < plainchars.length; i++) {
                charcode = (int) plainchars[i];
                if (charcode <= 90 && charcode >= 65) {
                    charcode = (charcode - 65 + cipherkey) % 26 + 65;
                } else if (charcode <= 122 && charcode >= 97) {
                    charcode = (charcode - 97 + cipherkey) % 26 + 97;
                }
                cipherchars[i] = (char) charcode;
            }
            ciphertext = new String(cipherchars);
            System.out.println(ciphertext);
        }
    }
}
