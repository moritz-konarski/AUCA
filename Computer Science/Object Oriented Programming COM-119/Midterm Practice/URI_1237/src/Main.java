import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string1, string2;
        int minLength;
        boolean breaking;
        while (scanner.hasNext()){
            breaking = false;
            string1 = scanner.nextLine();
            string2 = scanner.nextLine();
            minLength = Math.min(string1.length(), string2.length());
            for (int i = minLength; i > 0 && !breaking; i--){
                for (int offset = 0; offset <= minLength - i; offset++){
                    String substring = string2.substring(offset, i + offset);
                    if (string1.contains(substring) && !substring.isEmpty()){
                        minLength = string2.substring(offset, i).length();
                        breaking = true;
                        break;
                    }
                }
            }
            System.out.println(minLength);
        }
    }
}
