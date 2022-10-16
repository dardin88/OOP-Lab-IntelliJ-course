package it.unisa.railways;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ExpressTrainTest {

    @Test
    public void testSolution() {
        TrainStop SalernoStop = new TrainStop("Salerno", LocalTime.of(5, 15));
        TrainStop NapoliStop = new TrainStop("Napoli", LocalTime.of(5, 40));
        TrainStop RomaStop = new TrainStop("Roma", LocalTime.of(6, 40));
        TrainStop BolognaStop = new TrainStop("Bologna", LocalTime.of(8, 53));
        TrainStop MilanoStop = new TrainStop("Milano", LocalTime.of(9, 58));
        List<TrainStop> intermediateStops = new ArrayList<>();
        intermediateStops.add(NapoliStop);
        intermediateStops.add(RomaStop);
        intermediateStops.add(BolognaStop);
        ExpressTrain t = new ExpressTrain(SalernoStop, MilanoStop, intermediateStops, 457, 100, 876);
        Assert.assertEquals(5, t.getTotalNumberOfStops());
        Assert.assertEquals(226446, t.computeMaxRevenues(0.50, 0.30), 0);
    }
}
