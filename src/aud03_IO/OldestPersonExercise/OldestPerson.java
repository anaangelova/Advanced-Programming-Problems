package aud03_IO.OldestPersonExercise;

import java.io.*;
import java.util.Comparator;

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String line){
        String[] parts=line.split("\\s+");
        this.name=parts[0];
        this.age=Integer.parseInt(parts[1]);

    }

    @Override
    public String toString() {
        return String.format("%s %d",name,age);
    }

}

public class OldestPerson {

    public static void findOldestPerson(InputStream inputStream){
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        Person oldestPerson=
        br.lines().map(line -> new Person(line))
                .max(Comparator.comparingInt(p -> p.age)).orElseThrow();
        System.out.println(oldestPerson);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("C:\\Users\\Latinka\\Advanced Programming\\src\\people.txt");
        OldestPerson.findOldestPerson(new FileInputStream(file));
    }
}
