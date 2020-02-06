import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> allLowerCase = new ArrayList<>();
        String name = "";
        while (scanner.hasNextLine()){
            name = scanner.nextLine().trim();
            names.add(name);
            allLowerCase.add(name.toLowerCase());
        }
        Collections.sort(allLowerCase);
        Collections.reverse(allLowerCase);
        for (String element:names)
            if (element.equalsIgnoreCase(allLowerCase.get(0))){
                name = element;
                break;
            }

        System.out.println(name);
    }
}
