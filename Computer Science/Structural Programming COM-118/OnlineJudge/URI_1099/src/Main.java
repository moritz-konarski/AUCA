import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x, y;
        int count;

        for (int i = 0; i < n; i++){
            count = 0;
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (y < x){
                int temp = x;
                x = y;
                y = temp;
            }
            for (int m = x + 1; m < y; m++){
                if (m % 2 == 1){
                    count += m;
                }
            }
            System.out.println(count);
        }

    }
}
