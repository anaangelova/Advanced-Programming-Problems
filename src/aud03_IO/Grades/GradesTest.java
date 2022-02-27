package aud03_IO.Grades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GradesTest {

    public static void main(String[] args) throws FileNotFoundException {
        Course course=new Course();
        File file=new File("C:\\Users\\Latinka\\Advanced Programming\\src\\aud03\\students.txt");
        File outputFile=new File("C:\\Users\\Latinka\\Advanced Programming\\src\\aud03\\results.txt");
        course.readStudentsFromFile(new FileInputStream(file));
        course.printSortedStudents(System.out);
        course.printDetailedReportForStudents(new FileOutputStream(outputFile));
    }
}
