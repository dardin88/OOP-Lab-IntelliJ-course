import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(30, 20, 15, 45);

        // Dato un elenco di prezzi, calcola la somma dei prezzi superiori a 20 euro, scontati del 10%.
        double total = prices.stream()
                .filter(price -> price > 20)
                .map(price -> price * 0.9)
                .reduce((double) 0, (partial_result, value) -> partial_result + value);

        System.out.println(total);

        // Applica uno sconto del 20% ai prezzi inferiori a 25 euro e sommali.
        total = prices.stream()
                .filter(price -> price < 25)
                .map(price -> price * 0.8)
                .reduce((double) 0, (partial_result, value) -> partial_result + value);

        System.out.println(total);
    }
}