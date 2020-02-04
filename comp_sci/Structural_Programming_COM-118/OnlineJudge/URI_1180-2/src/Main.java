import java.util.Scanner;
public class Main {

    public static int getIndexOfMin(int[] array){
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        int index = getIndexOfMin(array);
        System.out.printf("Menor valor: %d%nPosicao: %d%n", array[index], index);
    }
}