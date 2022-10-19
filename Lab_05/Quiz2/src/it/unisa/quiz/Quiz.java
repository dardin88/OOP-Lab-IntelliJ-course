package it.unisa.quiz;

public class Quiz implements Comparable<Double> {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    public double getMeasure() {
        return score;
    }

    @Override
    public int compareTo(Double aDouble) {
        return Double.compare(this.score, aDouble);
    }
}
