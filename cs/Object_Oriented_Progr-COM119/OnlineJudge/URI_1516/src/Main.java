import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n, m, a, b;
        char[][] picture;
        while (true){
            n = scanner.nextInt();
            m = scanner.nextInt();
            scanner.nextLine();
            if (n == 0 && m == 0)
                break;
            picture = new char[n][];
            for (int i = 0; i < n; i++){
                picture[i] = scanner.nextLine().toCharArray();
            }
            a = scanner.nextInt();
            b = scanner.nextInt();
            for (char[] line : picture){
                for (int j = 0; j < a / n; j++) {
                    for (char symbol : line) {
                        for (int i = 0; i < b / m; i++) {
                            System.out.print(symbol);
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
