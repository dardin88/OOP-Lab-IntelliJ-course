package it.unisa.railways;

import java.util.List;

public class Train {
    private final TrainStop departureStation;
    private final TrainStop arrivalStation;
    private final List<TrainStop> intermediateStops;
    private final int numberOfSeats;
    private final double traveledKMs;

    public Train(TrainStop departureStation, TrainStop arrivalStation, List<TrainStop> intermediateStops, int numberOfSeats, double traveledKMs) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.intermediateStops = intermediateStops;
        this.numberOfSeats = numberOfSeats;
        this.traveledKMs = traveledKMs;
    }

    public TrainStop getDepartureStation() {
        return departureStation;
    }

    public TrainStop getArrivalStation() {
        return arrivalStation;
    }

    public List<TrainStop> getIntermediateStops() {
        return intermediateStops;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getTraveledKMs() {
        return traveledKMs;
    }

    public int getTotalNumberOfStops() {
        return this.intermediateStops.size() + 2;
    }

    public double computeMaxRevenues(double serviceRevenuePerKmPerson) {
        return this.traveledKMs * this.getNumberOfSeats() * serviceRevenuePerKmPerson;
    }
}