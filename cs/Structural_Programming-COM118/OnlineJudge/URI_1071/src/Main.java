import java.util.Scanner;
public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int count = 0;
        if (x<0 && y<0){
            for (int n = Math.min(y, x) + 1 ; n < Math.max(y, x); n++){
                if (Math.abs(n) % 2 == 1){
                    count+=n;
                }
            }
        }
        else {
            for (int n = Math.min(y, x) + 1 ; n < Math.max(y, x); n++){
                if (Math.abs(n) % 2 == 1){
                    count+=n;
                }
            }
        }
        System.out.println(count);
    }
}
