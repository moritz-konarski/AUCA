import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter three integers: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int sum = n1 + n2 + n3;
        int min = n1, max = n1;
        if (n2 > max){
            max = n2;
        }
        if (n3 > max){
            max = n3;
        }
        if (n2 < min){
            min = n2;
        }
        if (n3 < min){
            min = n3;
        }
        System.out.printf("%d\n%d\n%d\n", min, sum - (min + max), max);
    }
}
