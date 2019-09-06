import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int maiorAB = ( A + B + Math.abs(A - B))/ 2;
        int maiorAB_C = ( maiorAB + C + Math.abs(maiorAB - C))/ 2;
        System.out.printf("%d eh o maior\n", maiorAB_C);
    }
}
//a program that returns the biggest of three integers