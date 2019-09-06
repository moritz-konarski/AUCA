import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++){
            int sum = 0;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int oddNums = 0;
            for (int j = 0; oddNums < y; j++){
                if ((j + x) % 2 != 0) {
                    sum += x + j;
                    oddNums++;
                }
            }
            System.out.println(sum);
        }
    }
}
