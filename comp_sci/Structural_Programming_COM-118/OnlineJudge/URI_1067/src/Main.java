import java.util.Scanner;
public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        for (int n = 1; n <= x; n++){
            if (n % 2 == 1){
                System.out.println(n);
            }
        }
    }
}
