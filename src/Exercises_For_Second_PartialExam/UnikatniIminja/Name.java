package Exercises_For_Second_PartialExam.UnikatniIminja;

import java.util.Arrays;

public class Name {
    String name;
    int occurrences;

    public Name(String name) {
        this.name = name;
        this.occurrences = 0;
    }

    public int getLetters() {
        return (int) Arrays.stream(name.toLowerCase().split("")).distinct().count();

    }

    @Override
    public String toString() {
        return String.format("%s (%d) %d", name, occurrences, getLetters());
    }

}
