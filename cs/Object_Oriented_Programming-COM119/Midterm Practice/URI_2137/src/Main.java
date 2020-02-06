import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int lines;
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.clear();
            lines = scanner.nextInt();
            for (int i = 0; i < lines; i++){
                list.add(scanner.next());
            }
            Collections.sort(list);
            list.forEach(System.out::println);
        }
    }
}
