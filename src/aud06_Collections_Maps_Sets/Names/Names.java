package aud06_Collections_Maps_Sets.Names;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Names {

    public static Set<String> readNames(InputStream inputStream) {

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        return br.lines().map(b -> {
            List<String> parts = Arrays.stream(b.split("\\s+")).collect(Collectors.toList());
            return parts.get(0);
        }).collect(Collectors.toCollection(TreeSet::new));

    }

    public static Set<String> getUnisexNames(Set<String> boys, Set<String> girls) {
        boys.retainAll(girls);
        return boys;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> boys = readNames(new FileInputStream("C:\\Users\\Latinka\\Advanced Programming\\src\\aud06\\Names\\boysnames.txt"));
        Set<String> girls = readNames(new FileInputStream("C:\\Users\\Latinka\\Advanced Programming\\src\\aud06\\Names\\girlsnames.txt"));
        Set<String> unisexNames= getUnisexNames(boys,girls);
        System.out.printf("There are %d unisex names\n",unisexNames.size());
        unisexNames.forEach(n -> System.out.println(n));


    }

}
