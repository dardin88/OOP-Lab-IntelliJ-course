import org.junit.Assert;
import org.junit.Test;

public class MagicSquareTest {

    @Test
    public void trueMagicSquareTest() {
        MagicSquare square = new MagicSquare(4);
        square.add(16);
        square.add(3);
        square.add(2);
        square.add(13);
        square.add(5);
        square.add(10);
        square.add(11);
        square.add(8);
        square.add(9);
        square.add(6);
        square.add(7);
        square.add(12);
        square.add(4);
        square.add(15);
        square.add(14);
        square.add(1);
        Assert.assertTrue(square.isMagic());
    }

    @Test
    public void falseMagicSquareTest() {
        MagicSquare square = new MagicSquare(4);
        square.add(16);
        square.add(3);
        square.add(2);
        square.add(13);
        square.add(5);
        square.add(10);
        square.add(11);
        square.add(8);
        square.add(9);
        square.add(6);
        square.add(7);
        square.add(12);
        square.add(4);
        square.add(15);
        square.add(1);
        square.add(14);
        Assert.assertFalse(square.isMagic());
    }
}