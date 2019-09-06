import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int alcohol = 0;
        int gasoline = 0;
        int diesel = 0;
        boolean run = true;

        do {
            a = scanner.nextInt();
            switch (a){
                case 1:alcohol++;break;
                case 2:gasoline++;break;
                case 3:diesel++;break;
                case 4:run = false;break;
            }
        }while (run);
        System.out.printf("MUITO OBRIGADO%nAlcool: %d%nGasolina: %d%nDiesel: %d%n", alcohol, gasoline, diesel);
    }
}
