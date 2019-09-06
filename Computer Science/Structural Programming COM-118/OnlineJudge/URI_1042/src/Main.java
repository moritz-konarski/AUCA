import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N1 = scanner.nextInt();
        int N2 = scanner.nextInt();
        int N3 = scanner.nextInt();
        int max = Math.max(Math.max(N1, N2), N3);    //finding largest
        int min = Math.min(Math.min(N1, N2), N3);    //finding smallest
        int middle = (N1 + N2 + N3) - (min + max);   //finding the middle
        System.out.printf("%d\n%d\n%d\n\n%d\n%d\n%d\n",min, middle, max, N1, N2, N3); //printing the numbers as requested
    }
}
//a program that sorts three ints by size and outputs them in a specific way