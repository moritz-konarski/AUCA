import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[100];
        int n = 0;
        System.out.print("Enter integers between 1 and 100: ");
        while ((n = scanner.nextInt()) != 0){
            numbers[n - 1]++;
        }
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] != 0){
                System.out.printf("%d occurs %d times%n", i + 1, numbers[i]);
            }
        }
    }
}
