package it.unisa.railways;

import java.util.List;

public class ExpressTrain {
    private final TrainStop departureStation;
    private final TrainStop arrivalStation;
    private final List<TrainStop> intermediateStops;
    private final int numberOfSeats;
    private final int numberOfRestaurantSeats;
    private final double traveledKMs;

    public ExpressTrain(TrainStop departureStation, TrainStop arrivalStation, List<TrainStop> intermediateStops, int numberOfSeats, int numberOfRestaurantSeats, double traveledKMs) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.intermediateStops = intermediateStops;
        this.numberOfSeats = numberOfSeats;
        this.numberOfRestaurantSeats = numberOfRestaurantSeats;
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

    public int getNumberOfRestaurantSeats() {
        return numberOfRestaurantSeats;
    }

    public double getTraveledKMs() {
        return traveledKMs;
    }

    public int getTotalNumberOfStops() {
        return this.intermediateStops.size() + 2;
    }

    public double computeMaxRevenues(double serviceRevenuePerKmPerson, double restaurantRevenuePerKmPerson) {
        double serviceRevenue = this.traveledKMs * this.getNumberOfSeats() * serviceRevenuePerKmPerson;
        double restaurantRevenue = this.traveledKMs * this.getNumberOfRestaurantSeats() * restaurantRevenuePerKmPerson;
        return serviceRevenue + restaurantRevenue;
    }

}
