import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Luca", "Marco", "Giulia");
        // Stampa tutti i nomi
        names.forEach(name -> System.out.println(name));

        //Stampa solo i nomi che iniziano con 'G"
        names.stream().filter(name -> name.startsWith("G")).forEach(name -> System.out.println(name));
    }
}