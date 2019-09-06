import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nArray = new int[10];
        nArray[0] = scanner.nextInt();
        System.out.printf("N[0] = %d%n", nArray[0]);
        for (int i = 1; i < 10; i++) {
            nArray[i] = nArray[i - 1] * 2;
            System.out.printf("N[%d] = %d%n", i, nArray[i]);
        }
    }
}
