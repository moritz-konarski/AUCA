import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a, b;
        String resultString;
        while((a = scanner.nextInt()) + (b = scanner.nextInt()) > 0){
            resultString = String.format("%d", a + b);
            resultString = resultString.replace("0", "");
            System.out.println(resultString);
        }
    }
}
