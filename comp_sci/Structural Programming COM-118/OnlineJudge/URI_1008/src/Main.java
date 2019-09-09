import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int employeeNumber = scanner.nextInt();
        int workedHours = scanner.nextInt();
        double hourlyWage = scanner.nextDouble();
        double salary = hourlyWage * workedHours;
        System.out.println("NUMBER = " + employeeNumber);
        System.out.printf("SALARY = U$ %.2f\n", salary);
    }
}
//a program that computes the salary of an employee based on hourly wage and worked hours, output with employee number