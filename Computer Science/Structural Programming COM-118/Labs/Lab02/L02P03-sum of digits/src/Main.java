import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a 4-digit integer: ");
        int fourDigits = scanner.nextInt();
        int n_1000 = fourDigits / 1000;             //number of thousands
        int n_100 = (fourDigits % 1000) / 100;      //number of hundrets
        int n_10 = (fourDigits % 100) / 10;         //number of tens
        int n_1 = (fourDigits % 10);                //number of ones
        int sum = n_1 + n_10 + n_100 + n_1000;      //sum of them
        System.out.println("The sum of the four digits is: " + sum);
    }
}
