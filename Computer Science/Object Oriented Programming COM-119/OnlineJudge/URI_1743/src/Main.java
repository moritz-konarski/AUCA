import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char output = 'Y';
        //just add all the read-in values, then see that every one is one
        int[] ports = new int[5];
        for (int i = 0; i < 10; i++) {
            ports[i % 5] += scanner.nextInt();
        }
        for (int j = 0; j < 5; j++) {
            if (ports[j] != 1) {
                output = 'N';
                break;
            }
        }
        System.out.println(output);
    }
}
