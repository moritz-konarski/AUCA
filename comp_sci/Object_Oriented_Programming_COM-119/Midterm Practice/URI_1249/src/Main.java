import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] input;
        int shift;
        char comparison;
        while (scanner.hasNext()){
            input = scanner.nextLine().toCharArray();
            for (int i = 0; i < input.length; i++){
                if (Character.isLetter(input[i])) {
                    comparison = (Character.isLowerCase(input[i])) ? 'z' : 'Z';
                    shift = (input[i] + 13 > comparison) ? -13 : 13 ;
                    input[i] = (char)(input[i] + shift);
                }
            }
            System.out.println(new String(input));
        }
    }
}
