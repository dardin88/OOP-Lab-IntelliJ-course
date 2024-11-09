import java.util.Scanner;

public class TicTacToe {

    private final String[][] board;
    static final int ROWS = 3;
    static final int COLUMNS = 3;
    static final String player1 = "x";
    static final String player2 = "o";

    public TicTacToe() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = " ";
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            r.append("|");
            for (int j = 0; j < COLUMNS; j++)
                r.append(board[i][j]);
            r.append("|\n");
        }
        return r.toString();
    }

    public void set(int i, int j, String player) {
        if (board[i][j].equals(" "))
            board[i][j] = player;
    }

    public String getWinner() {
        int correctElementsForPlayer1 = 0;
        int correctElementsForPlayer2 = 0;

        // First, let's look at the rows.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j].equals(player1)) {
                    correctElementsForPlayer1++;
                    if (correctElementsForPlayer1 == 3) {
                        return player1;
                    }
                } else {
                    if (board[i][j].equals(player2)) {
                        correctElementsForPlayer2++;
                        if (correctElementsForPlayer2 == 3) {
                            return player2;
                        }
                    }
                }
            }
            correctElementsForPlayer1 = 0;
            correctElementsForPlayer2 = 0;
        }
        // First, let's look at the columns.
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (board[j][i].equals(player1)) {
                    correctElementsForPlayer1++;
                    if (correctElementsForPlayer1 == 3) {
                        return player1;
                    }
                } else {
                    if (board[j][i].equals(player2)) {
                        correctElementsForPlayer2++;
                        if (correctElementsForPlayer2 == 3) {
                            return player2;
                        }
                    }
                }
            }
            correctElementsForPlayer1 = 0;
            correctElementsForPlayer2 = 0;
        }

        // Finally, let's check the first diagonal
        for (int i = 0; i < ROWS; i++) {
            if (board[i][i].equals(player1)) {
                correctElementsForPlayer1++;
                if (correctElementsForPlayer1 == 3) {
                    return player1;
                }
            } else {
                if (board[i][i].equals(player2)) {
                    correctElementsForPlayer2++;
                    if (correctElementsForPlayer2 == 3) {
                        return player2;
                    }
                }
            }
        }
        correctElementsForPlayer1 = 0;
        correctElementsForPlayer2 = 0;

        // and the second diagonal...

        for (int j = 2, i = 0; j >= 0; j--, i++) {
            if (board[i][j].equals(player1)) {
                correctElementsForPlayer1++;
                if (correctElementsForPlayer1 == 3) {
                    return player1;
                }
            } else {
                if (board[i][j].equals(player2)) {
                    correctElementsForPlayer2++;
                    if (correctElementsForPlayer2 == 3) {
                        return player2;
                    }
                }
            }
        }
        return "Nessun vincitore";
    }

    public static void main(String[] args) {
        String player = player1;
        TicTacToe game = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int row, column;
        System.out.println(game);

        do {

            if (game.getWinner().equals(player1) || game.getWinner().equals(player2)) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci riga per " + player + " (-1 per uscire):");
            row = in.nextInt();

            if (row == -1) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci colonna per " + player + ":");
            column = in.nextInt();

            if (row >= ROWS || column >= COLUMNS) {
                System.out.println("Combinazione non valida");
            } else {
                // Set value on the board
                game.set(row, column, player);

                // Draw board
                System.out.println(game);

                // Get winnner
                System.out.println("Vince: " + game.getWinner());

                // Change player
                if (player.equals(player1)) {
                    player = player2;
                } else {
                    player = player1;
                }
            }

        } while (row < ROWS && column < COLUMNS);
    }
}