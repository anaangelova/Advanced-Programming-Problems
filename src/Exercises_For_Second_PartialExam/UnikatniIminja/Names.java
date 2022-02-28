package Exercises_For_Second_PartialExam.UnikatniIminja;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Names {
    Map<String, Name> namesMap;

    public Names() {
        this.namesMap = new TreeMap<>();
    }

    public void addName(String name) {
        namesMap.putIfAbsent(name, new Name(name));
        namesMap.computeIfPresent(name, (key, value) -> {
            value.occurrences++;
            return value;
        });

    }

    public void printN(int n) {
        namesMap.values()
                .stream()
                .filter(name -> name.occurrences >= n)
                .forEach(System.out::println);
    }

    public String findName(int len, int x) {
        List<String> list = namesMap.values()
                .stream()
                .filter(name -> name.name.length() < len)
                .map(name -> name.name)
                .collect(Collectors.toList());

        return list.get(x % list.size());
    }
}
