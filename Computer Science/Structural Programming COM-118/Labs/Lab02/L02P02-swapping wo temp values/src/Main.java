import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer a:");
        int a = scanner.nextInt();
        System.out.print("Enter integer b:");
        int b = scanner.nextInt();
        //printing the first version before swapping
        System.out.printf("Before Swapping: a = %d; b = %d\n", a, b);
        //switching the variables' values
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("After Swapping:  a = %d; b = %d", a, b);
    }
}