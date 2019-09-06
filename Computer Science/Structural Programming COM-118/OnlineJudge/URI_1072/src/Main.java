import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        int testcase = 0;
        int in = 0;
        int out = 0;

        for (int i = 0; i < iterations; i++){
            testcase = scanner.nextInt();
            if (testcase >= 10 && testcase <= 20){
                in++;
            }
            else {
                out++;
            }
        }
        System.out.printf("%d in\n%d out\n", in, out);

    }
}
// a program that tells you how numbers are part of an interval or not