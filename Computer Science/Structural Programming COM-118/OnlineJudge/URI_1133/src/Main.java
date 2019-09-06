import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int max = (a > b) ? a : b;
        int min = (a > b) ? b : a;
        for (int i = min + 1; i < max; i++){
            if (i % 5 == 2 || i % 5 == 3){
                System.out.println(i);
            }
        }
    }
}
