import java.util.Scanner;
import java.util.Random;
public class Main {

    public static int rollTwoDice(){
        Random random = new Random();
        return random.nextInt(6) + random.nextInt(6) + 2;
    }

    public static void main(String[] args){
        int[] diceRollArray = new int[11];
        Scanner scanner = new Scanner(System.in);

        System.out.print("N: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            diceRollArray[rollTwoDice() - 2]++;
        }

        for (int j = 0; j < diceRollArray.length; j++){
            System.out.printf("%2d: %d%n", j + 2, diceRollArray[j]);
        }
    }
}
