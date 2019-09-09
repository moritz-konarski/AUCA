import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int lines, maxLength;
        String[] inputLines;
        String output;
        lines = scanner.nextInt();
        while (lines != 0){
            inputLines = new String[lines];
            maxLength = 0;
            for (int i = 0; i < lines; i++){
                if ((inputLines[i] = scanner.nextLine()).equals(""))
                    inputLines[i] = scanner.nextLine();
                inputLines[i] = inputLines[i].replaceAll("\\s\\s+", " ");
                inputLines[i] = inputLines[i].trim();
                maxLength = (maxLength < inputLines[i].length()) ? inputLines[i].length() : maxLength;
            }
            output = "%" + maxLength + "s%n";
            for (String line : inputLines){
                System.out.printf(output, line);
            }
            lines = scanner.nextInt();
            if (lines == 0){
                break;
            }
            System.out.println();
        }
    }
}
