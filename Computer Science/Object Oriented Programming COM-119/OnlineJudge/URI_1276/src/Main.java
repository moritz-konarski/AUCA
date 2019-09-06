import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] letters;
        char start, end;
        String output;
        boolean[] contained;
        while (scanner.hasNext()){
            contained = new boolean[26];
            output = "";
            letters = scanner.nextLine().trim().replaceAll(" ", "").toCharArray();
            for (char letter:letters){
                contained[(int) letter - 97] = true;
            }
            int index = 0;
            for (int i = 0; i < 26; i++){
                if (contained[i]) {
                    start = end = (char) (i + 97);
                    i++;
                    while (i < 26 && contained[i]){
                        end = (char) (i + 97);
                        i++;
                    }
                    if (index == 0)
                        output = String.format("%c:%c", start, end);
                    else
                        output = output.concat(String.format(", %c:%c", start, end));
                    index++;
                }
            }
            System.out.println(output);
        }
    }
}
