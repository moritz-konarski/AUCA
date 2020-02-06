import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        float oldSalary = scanner.nextFloat();
        float newSalary;
        int raisePercent = 0;

        if (oldSalary <= 400){
            raisePercent = 15;
        }
        else if (oldSalary <= 800){
            raisePercent = 12;
        }
        else if (oldSalary <= 1200){
            raisePercent = 10;
        }
        else if (oldSalary <= 2000){
            raisePercent = 7;
        }
        else if (oldSalary > 2000){
            raisePercent = 4;
        }
        newSalary = oldSalary * (1f + raisePercent / 100.0f);
        System.out.printf("Novo salario: %.2f\n", newSalary);
        System.out.printf("Reajuste ganho: %.2f\n", newSalary - oldSalary);
        System.out.println("Em percentual: " + raisePercent + " %");
    }
}
// a program that computes raise and new salary of an employee based on the prior salary