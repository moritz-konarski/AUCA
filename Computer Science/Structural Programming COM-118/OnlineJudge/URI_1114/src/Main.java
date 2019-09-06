import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int password = 0;

        while (true){
            password = scanner.nextInt();
            if (password == 2002){
                System.out.println("Acesso Permitido");
                break;
            }
            else{
                System.out.println("Senha Invalida");
            }
        }
    }
}
