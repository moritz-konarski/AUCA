import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String password = sc.nextLine();
            boolean hasValidLength = password.length() >= 6 && password.length() <= 32,
                    hasLowerCase, hasUpperCase, hasDigit, hasNoSymbols;

            hasUpperCase = password.matches("\\w*[A-Z]\\w*"); // !password.equals(password.toLowerCase());
            hasLowerCase = password.matches("\\w*[a-z]\\w*"); // !password.equals(password.toUpperCase());
            hasDigit = password.matches("\\w*[0-9]\\w*");
            hasNoSymbols = !password.matches(".*\\s+.*");

            password = (hasValidLength && hasUpperCase &&
                    hasLowerCase && hasDigit &&
                    hasNoSymbols) ? "Senha valida." : "Senha invalida.";

            System.out.println(password);
        }
    }
}