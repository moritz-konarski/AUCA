import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int max = (a > b) ? a : b;
        int min = (a > b) ? b : a;
        int sum = 0;
        for (int i = min; i <= max; i++){
            if (i % 13 != 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
