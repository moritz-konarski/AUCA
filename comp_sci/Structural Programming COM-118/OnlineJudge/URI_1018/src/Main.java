import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println(value);
        int rest = value % 100;
        int n_100 = (value - rest) / 100;
        value = rest;

        rest = value % 50;
        int n_50 = (value - rest) / 50;
        value = rest;

        rest = value % 20;
        int n_20 = (value - rest) / 20;
        value = rest;

        rest = value % 10;
        int n_10 = (value - rest) / 10;
        value = rest;

        rest = value % 5;
        int n_5 = (value - rest) / 5;
        value = rest;

        rest = value % 2;
        int n_2 = (value - rest) / 2;

        int n_1 = rest;

        System.out.println(n_100 + " nota(s) de R$ 100,00");
        System.out.println(n_50 + " nota(s) de R$ 50,00");
        System.out.println(n_20 + " nota(s) de R$ 20,00");
        System.out.println(n_10 + " nota(s) de R$ 10,00");
        System.out.println(n_5 + " nota(s) de R$ 5,00");
        System.out.println(n_2 + " nota(s) de R$ 2,00");
        System.out.println(n_1 + " nota(s) de R$ 1,00");
    }
}
//a program that shows the number of bank notes that make up a sum of money