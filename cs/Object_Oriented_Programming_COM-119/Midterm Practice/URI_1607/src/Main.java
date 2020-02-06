import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), modifications;
        char[] a, b;
        for (int i = 0; i < iterations; i++){
            modifications = 0;
            a = scanner.next().toCharArray();
            b = scanner.next().toCharArray();
            for (int k = 0; k < a.length; k++){
                if (a[k] <= b[k])
                    modifications += b[k] - a[k];
                else
                    modifications += b[k] - a[k] + 26;
            }
            System.out.println(modifications);
        }
    }
}
