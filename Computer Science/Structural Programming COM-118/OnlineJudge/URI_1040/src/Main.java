import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float N1 = scanner.nextFloat();
        float N2 = scanner.nextFloat();
        float N3 = scanner.nextFloat();
        float N4 = scanner.nextFloat();

        double average = (2.0 * N1 + 3.0 * N2 + 4.0 * N3 + 1.0 * N4) / 10.0;
        System.out.printf("Media: %.1f\n", average);

        if (average >= 7.0)
        {
            System.out.println("Aluno aprovado.");
        }
        else if (average < 5.0)
        {
            System.out.println("Aluno reprovado.");
        }
        else if (average <= 6.9 && average >= 5.0)
        {
            System.out.println("Aluno em exame.");
            System.out.print("Nota do exame: ");
            float N5 = scanner.nextFloat();
            average = (((2.0 * N1 + 3.0 * N2 + 4.0 * N3 + 1.0 * N4) / 10.0) + N5) / 2.0;
            if (((((2.0 * N1 + 3.0 * N2 + 4.0 * N3 + 1.0 * N4) / 10.0) + N5) / 2.0) >= 5.0)
            {
                System.out.println("Aluno aprovado.");
            }
            else if (((((2.0 * N1 + 3.0 * N2 + 4.0 * N3 + 1.0 * N4) / 10.0) + N5) / 2.0) <= 4.9)
            {
                System.out.println("Aluno reprovado.");
            }
            System.out.printf("Media final: %.1f\n", average);
        }
    }
}
//a program that calculates a grade average and then tells you if the student failed, passed or needs an extra exam
//if there is an exam, the grade will then decide the final outcome