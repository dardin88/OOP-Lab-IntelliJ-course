import java.util.Scanner;

public class InputChecker {

    public String checkInput(String input) {
        if (input.equalsIgnoreCase("S") || input.equalsIgnoreCase("SI") || input.equalsIgnoreCase("OK") || input.equalsIgnoreCase("certo") || input.equalsIgnoreCase("perché no?")) {
            return "OK";
        } else {
            if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No")) {
                return "Fine";
            } else {
                return "Dato non corretto";
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Dammi l'input di verifica: ");
        String input = in.nextLine();

        InputChecker inputChecker = new InputChecker();
        System.out.println(inputChecker.checkInput(input));
    }
}