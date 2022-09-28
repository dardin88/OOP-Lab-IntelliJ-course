import org.junit.Assert;
import org.junit.Test;

public class CarTests {
    @Test
    public void testSolution() {
        Car car = new Car(0.05);
        car.addGas(10);
        Assert.assertEquals(10, car.getGas(), 0);
        car.drive(10);
        Assert.assertEquals(9.5, car.getGas(), 0);
    }
}