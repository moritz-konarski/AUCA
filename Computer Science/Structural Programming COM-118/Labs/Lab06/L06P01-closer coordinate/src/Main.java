import java.util.Scanner;
public class Main {

    public static int abs(int number){   //this method returns the absolute value of the argument
        return (number > 0) ? number : -number;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your coodinate: ");
        int userCoord = scanner.nextInt();
        System.out.print("Please enter the first coodinate: ");
        int firstCoord = scanner.nextInt();
        System.out.print("Please enter the second coodinate: ");
        int secondCoord = scanner.nextInt();

        int distance1 = abs(userCoord - firstCoord);
        int distance2 = abs(userCoord - secondCoord);

        if (distance1 > distance2){
            System.out.printf("The second point %d is closer. Distance is %d.", secondCoord, distance2);
        }
        else if (distance2 > distance1){
            System.out.printf("The first point %d is closer. Distance is %d.", firstCoord, distance1);
        }
        else {
            System.out.printf("Both points are the same distance away. Distance is %d", distance1);
        }
    }
}
