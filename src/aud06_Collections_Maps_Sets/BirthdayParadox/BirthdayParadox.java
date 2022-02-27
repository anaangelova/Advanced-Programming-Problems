package aud06_Collections_Maps_Sets.BirthdayParadox;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class BirthdayParadox {

    public static boolean singleTrial(int person) {
        Set<Integer> days = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < person; i++) {
            int randomBirthday = random.nextInt(1, 365);
            if (days.contains(randomBirthday)) {
                return true;
            }
            days.add(randomBirthday);
        }

        return false;

    }

    public static double experiment(int person){

        return IntStream.range(0,5000).filter(i -> singleTrial(person)).count() / 5000.0;
    }

    public static void main(String[] args) {
        for(int i=2;i<=50;i++){
            System.out.printf("For %d people, the probability of 2 birthdays is %.5f\n",i,BirthdayParadox.experiment(i));
        }
    }
}
