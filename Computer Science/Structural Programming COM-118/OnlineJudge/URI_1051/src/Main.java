import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        float salary = scanner.nextFloat();
        float totalTaxes = 0;
        float braketOne = 0;
        float braketTwo = 0;
        float braketThree = 0;

        if (salary <= 2000){
            System.out.println("Isento");
        }
        else if (salary <= 3000){
            braketOne = salary - 2000;
        }
        else if (salary <= 4500){
            braketOne = 1000;
            braketTwo = salary - 3000;
        }
        else {
            braketOne = 1000;
            braketTwo = 1500;
            braketThree = salary - 4500;
        }
        if (salary > 2000) {
            totalTaxes = braketThree * .28f + braketTwo * .18f + braketOne * .08f;
            //           over 4500                 3k-4.5k                  2k-3k
            System.out.printf("R$ %.2f\n", totalTaxes);
        }
    }
}
// a program that computes raise and new salary of an employee based on the prior salary