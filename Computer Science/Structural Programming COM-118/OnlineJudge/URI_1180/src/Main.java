import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int min = 1001;
        int index = 0;
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
            if (array[i] < min){
                index = i;
                min = array[i];
            }
        }
        System.out.printf("Menor valor: %d%nPosicao: %d%n", array[index], index);
    }
}
