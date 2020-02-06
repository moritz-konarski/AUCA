import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //read data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Temperature in Degrees Fahrenheit: ");
        double degFahrenheit = scanner.nextDouble();
        double degCelsius =  5.0 / 9.0 * (degFahrenheit - 32);  //order of evaluation is very important, pay attention
        System.out.printf("The temperature in degrees Celsius is %.2f", degCelsius);
    }
}
//a program that converts degrees fahrenheit to degrees celsius