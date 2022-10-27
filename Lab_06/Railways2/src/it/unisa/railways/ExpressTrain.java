package it.unisa.railways;

import java.util.List;

public class ExpressTrain extends Train {
    private final int numberOfRestaurantSeats;

    public ExpressTrain(TrainStop departureStation, TrainStop arrivalStation, List<TrainStop> intermediateStops, int numberOfSeats, int numberOfRestaurantSeats, double traveledKMs) {
        super(departureStation, arrivalStation, intermediateStops, numberOfSeats, traveledKMs);
        this.numberOfRestaurantSeats = numberOfRestaurantSeats;
    }

    public int getNumberOfRestaurantSeats() {
        return numberOfRestaurantSeats;
    }

    public double computeMaxRevenues(double serviceRevenuePerKmPerson, double restaurantRevenuePerKmPerson) {
        double restaurantRevenue = this.getTraveledKMs() * this.getNumberOfRestaurantSeats() * restaurantRevenuePerKmPerson;
        return super.computeMaxRevenues(serviceRevenuePerKmPerson) + restaurantRevenue;
    }

}
