import java.util.Random;
import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        BankAccount playerAccount = new BankAccount(1000);
        BankAccount casinoAccount = new BankAccount(100000);
        int predictedValue, actualValue;
        double bet;
        String choice = "no";
        Scanner in = new Scanner(System.in);

        do {

            do {
                System.out.println("Quale sarà il valore del dado?");
                predictedValue = in.nextInt();
                in.nextLine();
                if (predictedValue < 1 || predictedValue > 6) {
                    System.out.println("IL valore non è valido.");
                }
            } while (predictedValue < 1 || predictedValue > 6);

            do {
                System.out.println("Quanto vuoi scommettere?");
                bet = in.nextDouble();
                in.nextLine();
                if (playerAccount.getBalance() < bet || casinoAccount.getBalance() < bet * 5) {
                    System.out.println("La scommessa è troppo alta.");
                }
            } while (playerAccount.getBalance() < bet || casinoAccount.getBalance() < bet * 5);

            Random rnd = new Random();
            actualValue = rnd.nextInt(1, 7);
            System.out.println("Il dado ha restituito " + actualValue + ".");

            if (predictedValue == actualValue) {
                playerAccount.deposit(bet * 5);
                casinoAccount.withdraw(bet * 5);
                System.out.println("Hai vinto " + bet * 5 + ".");
            } else {
                playerAccount.withdraw(bet);
                casinoAccount.deposit(bet);
                System.out.println("Hai perso " + bet + ".");
            }

            if (playerAccount.getBalance() > 0) {
                System.out.println("Vuoi continuare a scommettere?");
                choice = in.nextLine();
            }

        } while (playerAccount.getBalance() > 0 && choice.equals("si"));

        System.out.println("Il tuo saldo è " + playerAccount.getBalance());

    }
}