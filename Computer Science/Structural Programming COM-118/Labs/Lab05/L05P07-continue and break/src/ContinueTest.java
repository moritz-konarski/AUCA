public class ContinueTest {
    public static void main(String[] args){
        int n = 0;
        int sum = 0;
        while (n < 20){
            n++;
            if (n == 11 || n == 10)
                continue;
            sum += n;
        }
        System.out.printf("The number is %d%nThe sum is %d", n, sum);
    }
}
