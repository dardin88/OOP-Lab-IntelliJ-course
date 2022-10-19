package it.unisa.country;

public class DataSet {

    private Country minimum;
    private Country maximum;
    private int count;

    public DataSet() {
        count = 0;
        minimum = null;
        maximum = null;
    }

    public Country getMaximum() {
        return maximum;
    }

    public Country getMinimum() {
        return minimum;
    }

    public void add(Country x) {
        if (count == 0 || x.compareTo(minimum) < 0)
            minimum = x;
        if (count == 0 || x.compareTo(maximum) > 0)
            maximum = x;
        count++;
    }
}