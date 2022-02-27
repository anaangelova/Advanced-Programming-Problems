package aud03_IO.Grades;

public class Student {
    private String name;
    private String lastname;
    private int exam1;
    private int exam2;
    private int exam3;

    public Student(String name, String lastname, int exam1, int exam2, int exam3) {
        this.name = name;
        this.lastname = lastname;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }
    public static Student getStudent(String line){
        String[] elements= line.split(":");
        return new Student(elements[0],elements[1],
                Integer.parseInt(elements[2]),Integer.parseInt(elements[3]),Integer.parseInt(elements[4]));
    }

    public double getTotalPoints(){
        return exam1*0.25+exam2*0.3+exam3*0.45;
    }
    public char getGrade(){
        double points=getTotalPoints();
        char grade='F';
        if(points>=90) grade='A';
        else if(points>=80) grade='B';
        else if(points>=70) grade='C';
        else if(points>=60) grade='D';
        else if (points>=50) grade='E';

        return grade;
    }

    public String studentWithGrade(){
        return String.format("%s %s %c", name,lastname,getGrade());
    }
    public String detailedReport(){
        return String.format("%s %s %d %d %d %.2f %c",name,lastname,exam1,exam2,exam3,getTotalPoints(),getGrade());
    }

}
