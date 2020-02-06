import java.util.Scanner;
public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int countEven = 0;
        int countPos = 0;
        int countZero = 0;

        for (int n = 0; n < 5; n++){

            x = scanner.nextInt();

            if (x % 2 == 0){
                countEven++;
            }
            if (x > 0) {
                countPos++;
            }
            if (x == 0){
                countZero++;
            }
        }
        System.out.println(countEven + " valor(es) par(es)");
        System.out.println(5-countEven + " valor(es) impar(es)");
        System.out.println(countPos + " valor(es) positivo(s)");
        System.out.println(5-countPos-countZero + " valor(es) negativo(s)");
    }
}
