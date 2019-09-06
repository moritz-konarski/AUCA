import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float average = 0;
        int age = 0;
        int cases = -1;
        do {
            average += age;
            cases++;
            age = 0;
            age = scanner.nextInt();
        }while (age > -1);
        System.out.printf("%.2f%n", average / cases);
    }
}
