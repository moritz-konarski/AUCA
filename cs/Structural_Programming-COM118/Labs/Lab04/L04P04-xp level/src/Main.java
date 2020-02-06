import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Complexity Level: ");
        int level = scanner.nextInt();
        switch (level){
            case 0:System.out.println("You are a total newbie");
                break;
            case 1:System.out.println("You are a beginner.");
                break;
            case 2:
            case 3:System.out.println("You are an experienced gamer.");
                break;
            case 4:
            case 5:System.out.println("You are a pro gamer.");
                break;
            default:System.err.println("Invalid Level.");
        }
    }
}
