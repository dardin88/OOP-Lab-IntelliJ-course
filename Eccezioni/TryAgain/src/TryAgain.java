import java.util.*;

public class TryAgain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int trials = 0;
        do {
            System.out.print("Dammi un double: ");
            try {
                sum += in.nextDouble();
                trials = 0;
            } catch (InputMismatchException ime) {
                trials++;
                if (trials == 2) {
                    break;
                }
            } finally {
                in.nextLine();
            }
        } while (true);

        System.out.println("Il totale dei valori inseriti è " + sum);
    }
}