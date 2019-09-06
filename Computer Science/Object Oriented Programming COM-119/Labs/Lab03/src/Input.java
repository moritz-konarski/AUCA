import java.util.Scanner;
import java.util.NoSuchElementException;

//a replacement for the scanner to make scanning for exceptions from Ctrl-D/Z easier
class Input {

    Input() {
    }

    //equivalent to scanner.next();
    String readNext() throws EndOfFileException {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        try {
            input = scanner.next().trim();
            return input;
        } catch (NoSuchElementException e) {
            throw new EndOfFileException();
        }
    }
}
