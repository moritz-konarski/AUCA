import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = 2;
        int n = 0;
        int X = 0;
        float x = 0;
        float y = 0;
        float sum = 0;
        boolean run = true;
        while (run) {
            sum = 0;
            n = 0;
            do {
                x = scanner.nextFloat();
                if (x >= 0 && x <= 10) {
                    sum += x;
                    n++;
                } else {
                    System.out.println("nota invalida");
                }
            } while (n < testCases);
            System.out.printf("media = %.2f%n", sum / 2);
            while (true){
                X = scanner.nextInt();
                System.out.println("novo calculo (1-sim 2-nao)");
                if (X == 1){
                    break;
                }
                else if (X == 2){
                    run = false;
                    break;
                }
            }
        }
    }
}
