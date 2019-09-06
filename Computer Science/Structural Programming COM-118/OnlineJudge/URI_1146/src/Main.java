import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true){
            n = scanner.nextInt();
            if (n == 0){break;}
            for (int i = 1; i < n; i++){
                System.out.print(i + " ");
            }
            System.out.println(n);
        }
    }
}

