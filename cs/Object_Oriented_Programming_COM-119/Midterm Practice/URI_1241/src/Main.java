import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        String a, b;
        for (int i = 0; i < iterations; i++){
            a = scanner.next();
            b = scanner.next();
            System.out.println((a.endsWith(b)) ? "encaixa" : "nao encaixa");
        }
    }
}
