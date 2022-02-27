package Exercises_For_Second_PartialExam.Anagrams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    static Map<String,List<String>> words=new TreeMap<>();

    public static void main(String[] args) {
        findAll(System.in);
    }

    public static void findAll(InputStream inputStream) {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(l -> {
            //da gi sortirame bukvite vo redosled vo ramki na zborot/linijata
            char[] letters=l.toCharArray();
            Arrays.sort(letters);
            String key=new String(letters);


            words.putIfAbsent(key,new ArrayList<>());
            words.get(key).add(l);
        });

        words.values().stream().filter(v -> v.size()>4)
                        .map(v -> v.stream().collect(Collectors.joining(" ")))
                                .sorted(Comparator.naturalOrder())
                                        .forEach(System.out::println);

    }
}
