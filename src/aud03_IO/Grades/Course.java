package aud03_IO.Grades;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Course {

    private List<Student> students;

    public Course() {
        students=new ArrayList<>();
    }

    public void readStudentsFromFile(InputStream inputStream){ //ok reshenie
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        this.students=bufferedReader.lines().map(l -> Student.getStudent(l)).collect(Collectors.toList());
    }

    public void printSortedStudents(OutputStream outputStream){ //ok reshenie
        PrintWriter printWriter=new PrintWriter(outputStream);
        students.stream().sorted(Comparator.comparing(Student::getGrade)).forEach(s -> printWriter.println(s.studentWithGrade()));
        printWriter.flush();
    }

    public void printDetailedReportForStudents(OutputStream outputStream){ //ok reshenie
        PrintWriter printWriter=new PrintWriter(outputStream);
        students.forEach(s -> printWriter.println(s.detailedReport()));
        printWriter.flush();
    }

    public void printGradeDistribution(OutputStream outputStream){
        //TODO
        PrintWriter printWriter=new PrintWriter(outputStream);
            /*students.stream().collect(Collectors.groupingBy(s -> s.getGrade()))*/

        printWriter.flush();
    }
}
