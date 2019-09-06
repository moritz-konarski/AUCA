import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nArray = new int[20];
        for (int i = 0; i < 20; i++) {
            nArray[i] = scanner.nextInt();
        }
        for (int j = 0; j < 10; j++){
            int temp = nArray[19 - j];
            nArray[19 - j] = nArray[j];
            nArray[j] = temp;
        }
        for (int k = 0; k < 20; k++){
            System.out.printf("N[%d] = %d%n", k, nArray[k]);
        }
    }
}
