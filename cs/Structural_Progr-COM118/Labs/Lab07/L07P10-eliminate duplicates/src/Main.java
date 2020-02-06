import java.util.Scanner;
public class Main {

    public static int[] eliminateDuplicates(int[] numbers){
        int[] numList = new int[numbers.length];
        numList[0] = numbers[0];
        int index = 1;
        boolean numberUnique;
        for (int i = 0; i < numbers.length; i++){       //for all elements of numbers
            numberUnique = true;
            for (int j = 0; j <= index; j++) {          //for all the occupied indices
                numberUnique &= (numbers[i] != numList[j]); //is this number found anywhere else?
            }
            if (numberUnique) {                         //if it is unique
                numList[index] = numbers[i];            //put it in the list
                index++;                                //increment the index
            }
        }
        //put numbers in an array that is appropriately sized
        int[] distNums = new int[index];
        for (int k = 0; k < index; k++){
            distNums[k] = numList[k];
        }
        return distNums;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.print("Please enter 10 numbers: ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.print("The distinct numbers are: ");
        for (int m : eliminateDuplicates(numbers)){
            System.out.printf("%d ", m);
        }
    }
}
