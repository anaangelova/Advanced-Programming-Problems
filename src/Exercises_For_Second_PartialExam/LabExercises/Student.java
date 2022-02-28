package Exercises_For_Second_PartialExam.LabExercises;

import java.util.Comparator;
import java.util.List;

public class Student {

    String index;
    List<Integer> points;

    public static Comparator<Student> comparator = Comparator.comparing(Student::getSummaryPoints).thenComparing(Student::getIndex);
    public static Comparator<Student> comparator2 = Comparator.comparing(Student::getIndex).thenComparing(Student::getSummaryPoints);

    public Student(String index, List<Integer> points) {
        this.index = index;
        this.points = points;
    }

    public double getSummaryPoints() {
        return points.stream().mapToDouble(point -> point).sum() / 10;

    }

    public boolean hasSignature() {
        return points.size() >= 8;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", index, hasSignature() ? "YES" : "NO", getSummaryPoints());
    }

    public int getYear() {
        return 20 - Integer.parseInt(index.substring(0, 2));
    }
    public String getIndex() {
        return index;
    }
}