import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int phoneCode = scanner.nextInt();
        String destination = "";
        switch (phoneCode) {
            case 61: destination = "Brasilia";
                break;
            case 71: destination = "Salvador";
                break;
            case 11: destination = "Sao Paulo";
                break;
            case 21: destination = "Rio de Janeiro";
                break;
            case 32: destination = "Juiz de Fora";
                break;
            case 19: destination = "Campinas";
                break;
            case 27: destination = "Vitoria";
                break;
            case 31: destination = "Belo Horizonte";
                break;
            default: destination = "DDD nao cadastrado";
        }
        System.out.println(destination);
    }
}
// a program that computes raise and new salary of an employee based on the prior salary