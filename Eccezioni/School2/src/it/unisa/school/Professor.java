package it.unisa.school;

public class Professor extends Person {

    private String topic;
    private float wage;

    public Professor(String name, String surname, int birthYear, String userId, String password, String topic, float wage) {
        super(name, surname, birthYear, userId, password);
        this.topic = topic;
        this.wage = wage;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Argomento='" + topic + '\'' +
                ", Stipendio=" + wage;
    }
}
