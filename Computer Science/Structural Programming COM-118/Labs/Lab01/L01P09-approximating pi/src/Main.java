//a program that approximates pi by multiplication and addition twice, but one time there is one less memeber in the series
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Without +1/13:");
        System.out.println("    Pi = " + 4 * ( 1.0 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11) )  );
        System.out.println("With +1/13:");
        System.out.println("    Pi = " + 4 * ( 1.0 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11) + (1.0 / 13) ) );
    }
}
