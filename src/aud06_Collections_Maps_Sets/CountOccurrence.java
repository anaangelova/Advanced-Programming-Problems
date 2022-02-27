package aud06_Collections_Maps_Sets;

import java.util.Collection;

public class CountOccurrence {

    public static int countFirstWay(Collection<Collection<String>> c, String str){
       return (int) c.stream().flatMap(l -> l.stream()).filter(s -> s.equalsIgnoreCase(str)).count();
    }
    public static int countSecondWay(Collection<Collection<String>> c, String str){
        return c.stream().flatMapToInt(sub -> sub.stream().mapToInt(s -> s.equalsIgnoreCase(str) ? 1 : 0)).sum();

    }
    public static long countThirdWay(Collection<Collection<String>> c, String str){
        return c.stream().mapToLong(d -> d.stream().filter(s -> s.equalsIgnoreCase(str)).count()).sum();

    }

    public static void main(String[] args) {

    }
}
