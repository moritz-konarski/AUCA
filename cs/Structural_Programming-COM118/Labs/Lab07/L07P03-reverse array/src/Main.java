import java.util.Scanner;
public class Main {

    public static int[] reverseArray(int[] array){
        int temp;
        int length = array.length;
        for (int i = 0; i < length / 2; i++){
            temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
        return array;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("N: ");
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++){
            System.out.printf("Enter %d element: ", i);
            array[i] = scanner.nextInt();
        }

        System.out.println("Before reversing:");
        for (int j : array) {
            System.out.printf("%d ", j);
        }

        array = reverseArray(array);

        System.out.println("\nAfter reversing:");
        for (int m : array) {
            System.out.printf("%d ", m);
        }
    }
}