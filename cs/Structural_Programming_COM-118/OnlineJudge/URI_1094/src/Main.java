import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nRepeat = scanner.nextInt();
        int animalN = 0;
        String animalCode = "";
        int frogN = 0;
        int rabbitN = 0;
        int ratN = 0;

        for (int i = 0; i < nRepeat; i++){
            animalN = scanner.nextInt();
            animalCode = scanner.next();
            switch (animalCode){
                case "C"://rabbit
                    rabbitN += animalN;
                    break;
                case "R"://rat
                    ratN += animalN;
                    break;
                case "S"://frog
                    frogN += animalN;
                    break;
            }

        }
        int animalTotal = ratN + rabbitN + frogN;
        System.out.printf("Total: %d cobaias\n", animalTotal);
        System.out.printf("Total de coelhos: %d\n", rabbitN);
        System.out.printf("Total de ratos: %d\n", ratN);
        System.out.printf("Total de sapos: %d\n", frogN);
        System.out.printf("Percentual de coelhos: %.2f %%\n", 100.0 * rabbitN / animalTotal);
        System.out.printf("Percentual de ratos: %.2f %%\n", 100.0 * ratN / animalTotal);
        System.out.printf("Percentual de sapos: %.2f %%\n", 100.0 * frogN / animalTotal);
    }
}
