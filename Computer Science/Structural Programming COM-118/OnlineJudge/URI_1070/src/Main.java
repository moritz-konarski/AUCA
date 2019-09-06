import java.util.Scanner;
public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x % 2 == 0){
            x++;
        }
        for (int n = x ; n < x + 12; n+=2){
                System.out.println(n);
        }
    }
}
