import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){

        double d = .1;
        for (int i = 0; i < 9; i++){
            d += .1;
        }
        if (d == 1.0){
            System.out.println("Equal");
        }
        else {
            System.out.println("Not Equal");
        }
        //this code does not work because doubles and floats are not exacts, while the conparison is. The double might be
        //0.99999999, so prractically one, but java correctly says that it is not == 1.0
        //a correct comparison can be achieved with big decimals, which is a bit complicated

        BigDecimal d2 = new BigDecimal("0.1");
        BigDecimal pointOne = new BigDecimal("0.1");
        BigDecimal one = new BigDecimal("1.0");
        for (int i = 0; i < 9; i++){
            d2 = d2.add(pointOne);
        }

        if (d2.compareTo(one) == 0){
            System.out.println("Equal");
        }
        else {
            System.out.println("Not Equal");
        }

        //alternatively, one can use a threshold to say from what point on two numbers are considered to be equal
        //if this is chosed with good enought accuracy it wont change much
        d = .1;
        double threshold = 1e-5;
        for (int i = 0; i < 9; i++){
            d += .1;
        }
        if (Math.abs(d - 1.0) < threshold){
            System.out.println("Equal");
        }
        else {
            System.out.println("Not Equal");
        }
    }
}
