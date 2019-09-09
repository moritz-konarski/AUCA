import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0){
            int sum = 0;
            for (int j = n; j <= n + 9; j++){
                sum = (j % 2 == 0) ? j + sum : sum;
            }
            System.out.println(sum);
            n = scanner.nextInt();
        }
    }
}
