import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if ((B % A ==0 || A % B ==0) && A != 0)
        {
            System.out.println("Sao Multiplos");
        }
        else
        {
            System.out.println("Nao sao Multiplos");
        }
    }
}
//a program that checks if one number is the multiple of the other