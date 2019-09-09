import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double decimal, cutoff, decimalDecimals;
        int result;
        while (scanner.hasNext()){
            decimal = Double.parseDouble(scanner.next());
            decimalDecimals = decimal - (int) decimal;
            cutoff = Double.parseDouble(scanner.next());
            result = (decimalDecimals > cutoff) ? (int) Math.ceil(decimal) : (int) decimal;
            System.out.println(result);
        }
    }
}
