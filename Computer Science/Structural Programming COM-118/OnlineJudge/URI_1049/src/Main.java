import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String w1 = scanner.next();
        String w2 = scanner.next();
        String w3 = scanner.next();
        boolean onivoro = false;
        boolean hematofago = false;
        String animal = "";

        if (w3.equals("onivoro")){
            onivoro = true;
        }
        if (w3.equals("hematofago")){
            hematofago = true;
        }

        if (w1.equals("vertebrado")){
            if (w2.equals("ave")){
                if (!onivoro){
                    animal = "aguia";
                }
                else {
                    animal = "pomba";
                }
            }
            else {
                if (onivoro){
                    animal = "homem";
                }
                else {
                    animal = "vaca";
                }
            }
        }
        else {
            if (w2.equals("inseto")){
                if (hematofago){
                    animal = "pulga";
                }
                else {
                    animal = "lagarta";
                }
            }
            else {
                if (hematofago){
                    animal = "sanguessuga";
                }
                else {
                    animal = "minhoca";
                }
            }
        }
        System.out.println(animal);
    }
}
// a program that computes raise and new salary of an employee based on the prior salary