import java.util.Scanner;
public class Main {
    public static void reverse(int[] array){
        int temp;
        for (int i = 0; i < array.length / 2; i++){
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in );
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        reverse(array);
        for (int j = 0; j < array.length; j++){
            System.out.printf("N[%d] = %d%n", j, array[j]);
        }
    }
}
