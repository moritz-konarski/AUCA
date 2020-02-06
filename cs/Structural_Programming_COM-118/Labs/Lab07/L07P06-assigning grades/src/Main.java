import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the number of students: ");
        int numberStudents = scanner.nextInt();
        int bestScore = 0;

        int[] scoreArray = new int[numberStudents];
        String[] gradeArray = new String[numberStudents];

        System.out.printf("Please enter %d scores: ", numberStudents);
        for (int i = 0; i < numberStudents; i++) {
            scoreArray[i] = scanner.nextInt();
            if (scoreArray[i] > bestScore){
                bestScore = scoreArray[i];
            }
        }
        for (int j = 0; j < numberStudents; j++){
            if (scoreArray[j] >= bestScore - 10){
                gradeArray[j] = "A";
            } else if (scoreArray[j] >= bestScore - 20){
                gradeArray[j] = "B";
            } else if (scoreArray[j] >= bestScore - 30){
                gradeArray[j] = "C";
            } else if (scoreArray[j] >= bestScore - 40){
                gradeArray[j] = "D";
            } else{
                gradeArray[j] = "F";
            }
            System.out.printf("Student %d score is %d and grade is %s%n", j, scoreArray[j], gradeArray[j]);
        }
    }
}