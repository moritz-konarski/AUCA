//a program that prints the first 50 prime numbers
public class Main {

    public static boolean isPrime(int number){
        boolean isPrime = true;
        for (int i = 2; i <= number/2; i++){
            if (number % i == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        int numbersPerRow = 0;
        final int NUMBER_OF_PRIMES = 50;
        final int PRIMES_PER_LINE = 10;
        int countOfPrimes = 0;
        int number = 2;
        System.out.printf("The first %d prime numbers are:%n", NUMBER_OF_PRIMES);
        while (countOfPrimes < NUMBER_OF_PRIMES) {
            if (isPrime(number)){
                System.out.printf("%4d", number);
                countOfPrimes++;
                if (countOfPrimes % PRIMES_PER_LINE == 0){
                    System.out.println();
                }
            }
            number++;
        }
    }
}