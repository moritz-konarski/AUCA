public class BreakTest {
    public static void main(String[] args){
        int n = 0;
        int sum = 0;
        while (n < 20){
            sum += n;
            n++;
            if (sum > 100)
                break;
        }
        System.out.printf("The number is %d%nThe sum is %d", n, sum);
    }
}
