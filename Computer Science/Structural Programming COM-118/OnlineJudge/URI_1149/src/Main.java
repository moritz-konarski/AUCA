import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n;
        int sum = 0;
        do {
            n = scanner.nextInt();
        }while (n < 1);

        for (int i = 0; i < n; i++){
            sum += a + i;
        }
        System.out.println(sum);
    }
}
