import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nPokemon = scanner.nextInt();
        final int maxPokemon = 151;
        String input;
        List<String> pokemonList = new ArrayList<>();
        for (int i = 0; i < nPokemon; i++) {
            input = scanner.next();
            if (!pokemonList.contains(input)) {
                pokemonList.add(input);
            }
        }
        System.out.printf("Falta(m) %d pomekon(s).%n", maxPokemon - pokemonList.size());
    }
}
