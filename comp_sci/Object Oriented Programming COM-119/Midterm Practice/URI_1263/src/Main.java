import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input;
        int alliterations, n;
        char currentAlliteration;
        boolean changed;
        while (scanner.hasNext()){
            alliterations = 0;
            changed = true;
            n = 0;
            input = scanner.nextLine().split(" ");
            currentAlliteration = input[0].charAt(0);
            for (int i = 1; i < input.length; i++){
                changed = (input[i].charAt(0) != currentAlliteration);
                n = changed ? 0 : n;
                if (!changed)
                    n++;
                if(n > 1)
                    alliterations++;
                currentAlliteration = input[i].charAt(0);
            }
            System.out.println(alliterations);
        }
    }
}
