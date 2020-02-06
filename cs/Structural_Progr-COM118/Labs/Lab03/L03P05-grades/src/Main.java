import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of points: ");
        int points = scanner.nextInt();
        String grade = " ";
        if (points > 100 || points < 0){
            System.out.println(points + " is not in the permitted range.");
        }
        else if (points >= 90){
            grade = "A";
        }
        else if (points >= 80){
            grade = "B";
        }
        else if (points >= 70){
            grade = "C";
        }
        else if (points >= 60){
            grade = "D";
        }
        else {
            grade = "F";
        }
        if (!grade.equals(" ")){
            System.out.println("Grade: " + grade);
        }
    }
}
