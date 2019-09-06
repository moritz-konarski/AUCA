import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] xArray = new int[10];
        for (int i = 0; i < 10; i++){
            xArray[i] = scanner.nextInt();
            xArray[i] = (xArray[i] <= 0) ? 1 : xArray[i];
            System.out.printf("X[%d] = %d%n", i, xArray[i]);
        }
    }
}
