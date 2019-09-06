import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[1000];
        for (int j = 0; j < 1000; j++) {
            array[j] = j % n;
            System.out.printf("N[%d] = %d%n", j, array[j]);
        }
    }
}
