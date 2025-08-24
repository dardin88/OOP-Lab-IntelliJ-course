package it.unisa.quiz;

public class Quiz implements Comparable<Quiz> {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    public double getMeasure() {
        return score;
    }

    @Override
    public int compareTo(Quiz quiz) {
        return Double.compare(this.score, quiz.getMeasure());
    }
}
