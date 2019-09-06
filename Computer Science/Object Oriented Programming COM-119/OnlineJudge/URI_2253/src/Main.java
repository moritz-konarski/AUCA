import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        while (scanner.hasNext()) {
            password = scanner.nextLine().trim();
            if (password.length() > 32 || password.length() < 6 // if the length is wrong
                    || password.matches(".*\\s.*")          // if there is whitespace
                    || !password.matches("\\w*[A-Z]\\w*")   // if there is no upper case letter
                    || !password.matches("\\w*[a-z]\\w*")   // if there is no lower case letter
                    || !password.matches("\\w*\\d\\w*")) {  // if there is no number
                System.out.println("Senha invalida.");
            } else {
                System.out.println("Senha valida.");
            }
        }
    }
}
