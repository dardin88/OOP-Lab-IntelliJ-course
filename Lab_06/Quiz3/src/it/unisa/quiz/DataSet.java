package it.unisa.quiz;

public class DataSet {

    private double sum;
    private Measurable minimum;
    private Measurable maximum;
    private int count;

    public DataSet() {
        count = 0;
        sum = 0;
        minimum = null;
        maximum = null;
    }

    public double getAverage() {
        if (count == 0) return 0;
        else return sum / count;
    }

    public Measurable getMaximum() {
        return maximum;
    }

    public Measurable getMinimum() {
        return minimum;
    }

    public void add(Measurable x) {
        sum = sum + x.getMeasure();
        if (count == 0 || x.compareTo(minimum) < 0)
            minimum = x;
        if (count == 0 || x.compareTo(maximum) > 0)
            maximum = x;
        count++;
    }
}