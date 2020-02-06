import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        int testcase = 0;

        for (int i = 0; i < iterations; i++){
            testcase = scanner.nextInt();

            if (testcase > 0){
                if (testcase % 2 == 0){
                    System.out.println("EVEN POSITIVE");
                }
                else {
                    System.out.println("ODD POSITIVE");
                }
            }
            else if (testcase < 0){
                if (testcase % 2 == 0){
                    System.out.println("EVEN NEGATIVE");
                }
                else {
                    System.out.println("ODD NEGATIVE");
                }
            }
            else {
                System.out.println("NULL");
            }

        }

    }
}
// a program that tells you how numbers are part of an interval or not