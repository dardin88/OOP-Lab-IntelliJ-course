import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
    @Test
    public void addCansTest() {
        VendingMachine vm = new VendingMachine();
        vm.addCans(10);
        Assert.assertEquals(10, vm.getNumberOfCans(), 0);
    }

    @Test
    public void takeCansTest() {
        VendingMachine vm = new VendingMachine();
        vm.addCans(10);
        vm.takeCan();
        Assert.assertEquals(9, vm.getNumberOfCans(), 0);
        Assert.assertEquals(1, vm.getNumberOfTokens(), 0);
    }

    @Test
    public void takeMoneyTest() {
        VendingMachine vm = new VendingMachine(10);
        vm.takeCan();
        vm.takeCan();
        Assert.assertEquals(2, vm.getNumberOfTokens(), 0);
        vm.takeTokens();
        Assert.assertEquals(0, vm.getNumberOfTokens(), 0);
    }
}