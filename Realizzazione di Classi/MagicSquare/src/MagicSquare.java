import java.util.Scanner;

public class MagicSquare {
    private final int[][] square;
    private final int n;

    public MagicSquare(int n) {
        this.n = n;
        square = new int[n][n];
    }

    private boolean find(int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFull() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void add(int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == 0) {
                    square[i][j] = x;
                    return;
                }
            }
        }
    }

    public boolean isMagic() {
        int magicNumber = 0;
        boolean isMagic = true;

        //Calculate sum of the first row
        for (int j = 0; j < n; j++)
            magicNumber += square[0][j];

        //Calculate sum of 2nd and 3rd row
        for (int i = 1; i < n; i++) {
            int sum_row = 0;
            for (int j = 0; j < n; j++)
                sum_row += square[i][j];
            if (sum_row != magicNumber) {
                isMagic = false;
                break;
            }
        }

        //Calculate sum of each column
        if (isMagic) {
            for (int j = 0; j < n; j++) {
                int sum_col = 0;
                for (int i = 0; i < n; i++)
                    sum_col += square[i][j];
                if (sum_col != magicNumber) {
                    isMagic = false;
                    break;
                }
            }
        }

        //Calculate sum of first diagonal
        if (isMagic) {
            int sum_diagonal = 0;
            int j = 0;
            for (int i = 0; i < n; i++) {
                sum_diagonal += square[i][j];
                j++;
            }
            if (sum_diagonal != magicNumber) {
                isMagic = false;
            }
        }

        //Calculate sum of second diagonal
        if (isMagic) {
            int sum_diagonal = 0;
            int j = 0;
            for (int i = n - 1; i >= 0; i--) {
                sum_diagonal += square[i][j];
                j++;
            }
            if (sum_diagonal != magicNumber) {
                isMagic = false;
            }
        }

        return isMagic;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                toString.append(square[i][j]).append(" ");
            }
            toString.append("\n");
        }
        return toString.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci n --> ");
        int n = input.nextInt();
        MagicSquare square = new MagicSquare(n);

        while (!square.isFull()) {
            int x;
            do {
                System.out.print("Inserisci un numero --> ");
                x = input.nextInt();

                if (x < 1 || x > n * n) {
                    System.out.println("Devi inserire numeri compresi tra 1 e n^2!");
                } else {
                    if (square.find(x)) {
                        System.out.println("Questo numero lo avevi già inserito!");
                    }
                }
            } while (square.find(x) || x < 1 || x > n * n);
            square.add(x);
            System.out.println(square);
        }

        boolean magic = square.isMagic();

        if (magic)
            System.out.println("È un quadrato magico!");
        else
            System.out.println("Non è un quadrato magico!");
    }
}