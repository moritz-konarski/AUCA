import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iteration = scanner.nextInt(), lines;
        String first;
        for (int i = 0; i < iteration; i++){
            lines = scanner.nextInt(); scanner.nextLine();
            first = scanner.next();
            for (int j = 0; j < lines - 1; j++)
                if (!(scanner.next().equals(first)))
                    first = "ingles";
            System.out.println(first);
        }
    }
}
