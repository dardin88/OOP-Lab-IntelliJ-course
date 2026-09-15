import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Sara", "Scott");

        // Converti una lista di nomi in maiuscolo e stampali usando map e forEach
        friends.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // stampa la lunghezza di ogni nome
        friends.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}