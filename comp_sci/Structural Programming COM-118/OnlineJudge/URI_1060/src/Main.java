import java.util.Scanner;
public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        double x = 0;
        int count = 0;

        for (int n = 0; n < 6; n++){

            x = scanner.nextDouble();

            if (x > 0){
                count++;
            }
        }
        System.out.println(count + " valores positivos");
    }
}
