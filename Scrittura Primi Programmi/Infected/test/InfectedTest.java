import org.junit.Assert;
import org.junit.Test;

public class InfectedTest {

    @Test
    public void rtGoingDownTest() {
        Infected infected = new Infected("Covid19");
        Assert.assertEquals("Covid19", infected.getDisease());
        Assert.assertEquals(0, infected.getNumberOfInfected(), 0);

        infected.addInfected(100);
        Assert.assertEquals(100, infected.getNumberOfInfected(), 0);

        infected.updateInfectedByRt(0.9);
        Assert.assertEquals(90, infected.getNumberOfInfected(), 0);
    }

    @Test
    public void rtGoingUpTest() {
        Infected infected = new Infected("Covid19", 100);
        Assert.assertEquals("Covid19", infected.getDisease());
        Assert.assertEquals(100, infected.getNumberOfInfected(), 0);

        infected.updateInfectedByRt(1.1);
        Assert.assertEquals(110, infected.getNumberOfInfected(), 0);
    }
}