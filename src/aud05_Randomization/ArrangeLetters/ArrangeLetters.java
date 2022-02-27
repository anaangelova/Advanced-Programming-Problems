package aud05_Randomization.ArrangeLetters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrangeLetters {

    public static String arrange(String sentence) {
        List<String> words = Arrays.stream(sentence.split("\\s+")).toList();

       return  words.stream().map(w -> {
            char[] chars = w.toCharArray();
            List<Character> allChars = new ArrayList<>();
            IntStream.range(0, chars.length).forEach(c -> allChars.add(chars[c]));
            allChars.sort(Comparator.naturalOrder());

            StringBuilder sb = new StringBuilder();
            allChars.stream().forEach(c -> sb.append(c));
            return sb.toString();
        })
               .sorted(Comparator.naturalOrder()).collect(Collectors.joining(" "));



    }

    public static void main(String[] args) {
        System.out.println(ArrangeLetters.arrange("angeLa A naprEdno"));
    }
}
