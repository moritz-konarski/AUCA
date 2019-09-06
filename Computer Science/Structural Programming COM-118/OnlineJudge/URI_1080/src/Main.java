import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int max = n;
        int position = 0;
        for (int i = 1; i < 101; i++){
            n = scanner.nextInt();
            if (n > max){
                max = n;
                position = i;
            }
        }
        System.out.printf("%d\n%d\n", max, position);
    }
}
