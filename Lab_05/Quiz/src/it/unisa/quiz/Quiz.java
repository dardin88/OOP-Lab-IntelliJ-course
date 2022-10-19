package it.unisa.quiz;

public class Quiz implements Measurable {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    @Override
    public double getMeasure() {
        return score;
    }
}
