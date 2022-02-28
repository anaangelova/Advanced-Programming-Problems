package Exercises_For_Second_PartialExam.LabExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LabExercises {
    List<Student> students;

    public LabExercises() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printByAveragePoints(boolean ascending, int n) {

        if (ascending) {
            students.stream()
                    .sorted(Student.comparator)
                    .limit(n).forEach(System.out::println);
        } else students.stream()
                .sorted(Student.comparator.reversed())
                .limit(n).forEach(System.out::println);

    }

    public List<Student> failedStudents() {

        return students.stream().filter(student -> !(student.hasSignature())).sorted(Student.comparator2)
                .collect(Collectors.toList());
    }

    public Map<Integer, Double> getStatisticsByYear() {
        return students.stream().filter(Student::hasSignature)
                .collect(Collectors.groupingBy(student -> student.getYear(),
                        Collectors.averagingDouble(Student::getSummaryPoints)));
    }
}
