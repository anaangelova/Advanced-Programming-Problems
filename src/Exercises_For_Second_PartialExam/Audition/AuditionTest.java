package Exercises_For_Second_PartialExam.Audition;

import java.util.*;

class Participant {
    String city;
    String code;
    String name;
    int age;
    public static Comparator<Participant> comparator = Comparator.comparing(Participant::getName).thenComparing(Participant::getAge).thenComparing(Participant::getCode);

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Participant(String city, String code, String name, int age) {
        this.city = city;
        this.code = code;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", code, name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

class Audition {
    Map<String, Set<Participant>> participantsByCity;

    public Audition() {
        this.participantsByCity = new HashMap<>();
    }

    public void addParticpant(String city, String code, String name, int age) {

        participantsByCity.putIfAbsent(city,
                new HashSet<>());

        participantsByCity.computeIfPresent(city, (k, v) -> {
            v.add(new Participant(city, code, name, age));
            return v;
        });


    }

    public void listByCity(String city) {
        participantsByCity.getOrDefault(city, new HashSet<>())
                .stream().sorted(Participant.comparator)
                .forEach(p -> System.out.println(p));


    }
}

public class AuditionTest {
    public static void main(String[] args) {
        Audition audition = new Audition();
        List<String> cities = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length > 1) {
                audition.addParticpant(parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3]));
            } else {
                cities.add(line);
            }
        }
        for (String city : cities) {
            System.out.printf("+++++ %s +++++\n", city);
            audition.listByCity(city);
        }
        scanner.close();
    }
}