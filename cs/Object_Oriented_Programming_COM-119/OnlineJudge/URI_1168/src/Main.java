/*THIS PROGRAM ONLY WORKS IN JAVA 8 ON URI*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        int nLEDs = 0, totalLEDs;
        String input;
        String[] elements;
        int[] nDigits;
        for (int i = 0; i < iterations; i++){
            nDigits = new int[10];
            totalLEDs = 0;
            input = scanner.next();
            elements = input.split("");
            for (String element: elements){
                nDigits[Integer.parseInt(element)]++;
            }
            for (int n = 0; n < nDigits.length; n++){
                switch (n){
                    case 1:nLEDs = 2 * nDigits[n];
                        break;
                    case 2:
                    case 3:
                    case 5:nLEDs = 5 * nDigits[n];
                        break;
                    case 4:nLEDs = 4 * nDigits[n];
                        break;
                    case 6:
                    case 9:
                    case 0:nLEDs = 6 * nDigits[n];
                        break;
                    case 7:nLEDs = 3 * nDigits[n];
                        break;
                    case 8:nLEDs = 7 * nDigits[n];
                        break;
                }
                totalLEDs += nLEDs;
            }
            System.out.printf("%d leds%n", totalLEDs);
        }
    }
}
