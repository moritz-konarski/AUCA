import java.sql.Array;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int codeP1 = scanner.nextInt();
        int unitsP1 = scanner.nextInt();
        float priceP1 = scanner.nextFloat();

        int codeP2 = scanner.nextInt();
        int unitsP2 = scanner.nextInt();
        float priceP2 = scanner.nextFloat();

        float price = unitsP1 * priceP1 + unitsP2 * priceP2;

        System.out.printf("VALOR A PAGAR: R$ %.2f\n", price);
    }
}
//a program that computes the total price of two different products