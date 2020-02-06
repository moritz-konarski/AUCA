import java.util.Scanner;
public class Main {

    public static int indexOfSmallesElement(double[] array){
        int index = 0;
        double min = array[index];
        for (int i = array.length - 1; i >= 0; i--){
            if (array[i] <= min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double[] array = new double[10];
        System.out.print("Please enter ten integers: ");
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextDouble();
        }
        int index = indexOfSmallesElement(array);
        System.out.printf("The smallest number %.3f the index %d", array[index], index);
    }
}
