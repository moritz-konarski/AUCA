import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Plese enter the weight of the package (in lb): ");
        double weight = scanner.nextDouble();
        double cost = 0;
        if (weight <= 0){
            System.err.println("Please enter a correct weight.");
            System.exit(-1);
        }
        else if (weight <= 1){
            cost = 3.5;
        }
        else if (weight <= 3){
            cost = 5.5;
        }
        else if (weight <= 10){
            cost = 8.5;
        }
        else if (weight <= 20){
            cost = 10.5;
        }
        else if (weight > 50){
            System.err.println("This package is too heavy and can not be shipped.");
            System.exit(-1);
        }
        else {
            System.err.println("No cost can be calculated.");
            System.exit(-1);
        }
        System.out.printf("Shipping this package will cost $%.2f", cost);
    }
}
