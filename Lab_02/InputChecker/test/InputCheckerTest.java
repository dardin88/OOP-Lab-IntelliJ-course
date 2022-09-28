import org.junit.Assert;
import org.junit.Test;

public class InputCheckerTest {
    @Test
    public void OKTest() {
        InputChecker inputChecker = new InputChecker();
        Assert.assertEquals("OK", inputChecker.checkInput("S"));
        Assert.assertEquals("OK", inputChecker.checkInput("SI"));
        Assert.assertEquals("OK", inputChecker.checkInput("OK"));
        Assert.assertEquals("OK", inputChecker.checkInput("certo"));
        Assert.assertEquals("OK", inputChecker.checkInput("perché no?"));
    }

    @Test
    public void FineTest() {
        InputChecker inputChecker = new InputChecker();
        Assert.assertEquals("Fine", inputChecker.checkInput("N"));
        Assert.assertEquals("Fine", inputChecker.checkInput("NO"));
    }

    @Test
    public void AltroTest() {
        InputChecker inputChecker = new InputChecker();
        Assert.assertEquals("Dato non corretto", inputChecker.checkInput("altro dato"));
    }
}