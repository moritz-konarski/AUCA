import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        String number;
        for (int i = 0; i < iterations; i++){
            number = scanner.next();
            if (number.length() == 5){
                System.out.println(3);
            }
            else{
                if (number.matches("[a-z]ne|o[a-z]e|on[a-z]")){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }
        }
    }
}
