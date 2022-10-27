package it.unisa.railways;

import java.time.LocalTime;

public class TrainStop {
    private final String stationName;
    private final LocalTime time;

    public TrainStop(String stationName, LocalTime time) {
        this.stationName = stationName;
        this.time = time;
    }
}
