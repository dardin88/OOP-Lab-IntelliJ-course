import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String firstName;
    private final String lastName;
    private final List<Exam> exams;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.exams = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void registerExam(Exam exam) {
        this.exams.add(exam);
    }

    public double computeAverageGrade() {
        double averageGrade = 0;
        for (Exam exam : this.exams) {
            averageGrade += exam.getGrade();
        }
        averageGrade /= exams.size();
        return averageGrade;
    }
}