import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        double fixedSalary;
        double totalSales;
        double salary = 0;
        Scanner scanner = new Scanner(System.in);
        String employeeName = scanner.nextLine();
        fixedSalary = scanner.nextDouble();
        totalSales = scanner.nextDouble();
        salary = fixedSalary + totalSales * 0.15;
        System.out.printf("SALARY = R$ %.2f\n", salary);
    }
}
//a program that computes the salary of an employee based on fixed wage + bonus of 15% of their total sales