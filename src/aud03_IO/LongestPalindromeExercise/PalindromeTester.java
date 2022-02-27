package aud03_IO.LongestPalindromeExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromeTester {

    List<String> words;

    public PalindromeTester() {
        words = new ArrayList<>();
    }

    public static boolean isPalindrome(String word) {
       /* for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
        } prv pristap
        return true;*/

        StringBuilder stringBuilder=new StringBuilder();
        /*for(int i=word.length()-1;i>=0;i--){
            stringBuilder.append(word.charAt(i));
        }
        reverseWord=stringBuilder.toString(); vtor pristap */

       /* String reverseWord=stringBuilder.append(word).reverse().toString(); tret pristap
        return reverseWord.equals(word);*/

                        //kazhuva kolku pati kje se povtori allMatch
        return IntStream.range(0, word.length()/2).allMatch(i -> word.charAt(i)==word.charAt(word.length()-1-i));
    }

    public void readData(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        words = bufferedReader.lines()
                .map(l -> l.toLowerCase()) //vazhno!
                .collect(Collectors.toList());
    }
    public String getLongestPalindrome(){
        return words.stream().filter(w -> isPalindrome(w)).max(Comparator.comparing(String::length)).orElseThrow();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Latinka\\Advanced Programming\\src\\aud03\\LongestPalindromeExercise\\words.txt");
        PalindromeTester palindromeTester = new PalindromeTester();
        palindromeTester.readData(new FileInputStream(file));
        System.out.println(palindromeTester.getLongestPalindrome());
    }
}
