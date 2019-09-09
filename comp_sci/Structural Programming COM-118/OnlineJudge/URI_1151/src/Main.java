import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n0 = 0;
        int n1 = 0;
        int n2 = 1;
        System.out.print("0");
        for (int i = 1; i < n; i++){
            n0 = n1 + n2;
            n2 = n1;
            n1 = n0;
            System.out.printf(" %d", n0);
        }
        System.out.println();
    }
}
