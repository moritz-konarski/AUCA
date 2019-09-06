import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String toBeReplaced, replacement, tag, regex, replacementText;
        while (scanner.hasNextLine()){
            toBeReplaced = scanner.nextLine().toLowerCase();
            replacement = scanner.nextLine();
            tag = scanner.nextLine();
            regex = String.format("(?i)(<[^>]*)(%s)([^>]*>)", toBeReplaced);
            while (tag.matches(".*" + regex + ".*")) {
                replacementText = String.format("$1%s$3", replacement);
                tag = tag.replaceAll(regex, replacementText);
            }
            System.out.println(tag);
        }
    }
}
