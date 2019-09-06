import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), groupMembers;
        String language, output;
        for (int i = 0; i < iterations; i++){
            groupMembers = scanner.nextInt();
            language = output = scanner.next();
            for (int j = 0; j < groupMembers - 1; j++){
                if (!language.equals(language = scanner.next())) {
                    output = "ingles";
                }
            }
            System.out.println(output);
        }
    }
}
