import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String geneticCode, resistanceGenes, regex;
        while (scanner.hasNext()){
            geneticCode = scanner.next();
            resistanceGenes = scanner.next();
            regex = String.format(".*%s.*", resistanceGenes);
            if (geneticCode.matches(regex))
                System.out.println("Resistente");
            else
                System.out.println("Nao resistente");
        }
    }
}
