import java.util.Arrays;
import java.util.List;

public class Main {

    private static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Calcola la somma di una lista di interi usando Integer::sum
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // Calcola il prodotto di tutti i numeri
        int product = numbers.stream().reduce(1, Main::multiply);
        System.out.println(product);
    }
}