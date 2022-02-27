package aud05_Randomization.Finalists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPicker {


    public static List<Finalist> rewarded(int finalists, int awards){
        Random random=new Random();
        List<Finalist> awarded=new ArrayList<>();
        while(awarded.size()!=awards){
            int picked=random.nextInt(1,finalists+1);
            Finalist finalist=new Finalist(picked);
            boolean isPicked=awarded.stream().anyMatch(a -> a.equals(finalist));
            if(!isPicked)
                awarded.add(finalist);
        }
        return awarded;
    }


    public static void main(String[] args) {
        List<Finalist> awarded= RandomPicker.rewarded(30,3);
        awarded.stream().forEach(f -> System.out.println(f));
    }
}
