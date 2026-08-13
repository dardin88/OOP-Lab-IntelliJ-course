import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "kiwi", "strawberry"};

        // Ordina una lista di parole in base alla lunghezza usando una lambda expression.
        Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(words));

        // Ordina in maniera decrescente di lunghezza.
        Arrays.sort(words, (first, second) -> Integer.compare(second.length(), first.length()));
        System.out.println(Arrays.toString(words));
    }
}