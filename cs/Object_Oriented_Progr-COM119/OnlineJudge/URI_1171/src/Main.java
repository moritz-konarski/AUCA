import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int nInputs = scanner.nextInt(), input;
        ArrayList<Integer> inputs = new ArrayList<>();
        Hashtable<Integer, Integer> count = new Hashtable<>();

        for (int i = 0; i < nInputs; i++) {
            input = scanner.nextInt();
            if (!inputs.contains(input)) {
                inputs.add(input);
                count.put(input, 1);
            }
            else {
                count.put(input, count.get(input) + 1);
            }
        }

        Collections.sort(inputs);
        for (int number : inputs) {
            System.out.printf("%d aparece %d vez(es)%n", number, count.get(number));
        }
    }
}
