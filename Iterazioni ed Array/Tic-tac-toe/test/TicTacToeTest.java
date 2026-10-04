import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void horizontalWinTest() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, TicTacToe.player1);
        game.set(0, 1, TicTacToe.player1);
        game.set(0, 2, TicTacToe.player1);
        Assert.assertEquals(TicTacToe.player1, game.getWinner());
    }

    @Test
    public void verticalWinTest() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, TicTacToe.player2);
        game.set(1, 0, TicTacToe.player2);
        game.set(2, 0, TicTacToe.player2);
        Assert.assertEquals(TicTacToe.player2, game.getWinner());
    }

    @Test
    public void firstDiagonalWinTest() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, TicTacToe.player1);
        game.set(1, 1, TicTacToe.player1);
        game.set(2, 2, TicTacToe.player1);
        Assert.assertEquals(TicTacToe.player1, game.getWinner());
    }

    @Test
    public void secondDiagonalWinTest() {
        TicTacToe game = new TicTacToe();
        game.set(2, 0, TicTacToe.player2);
        game.set(1, 1, TicTacToe.player2);
        game.set(0, 2, TicTacToe.player2);
        Assert.assertEquals(TicTacToe.player2, game.getWinner());
    }

    @Test
    public void AndreaTest() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, TicTacToe.player1);
        game.set(0, 1, TicTacToe.player2);
        game.set(1, 0, TicTacToe.player1);
        game.set(1, 1, TicTacToe.player2);
        game.set(2, 1, TicTacToe.player1);
        Assert.assertEquals("Nessun vincitore", game.getWinner());
    }
}