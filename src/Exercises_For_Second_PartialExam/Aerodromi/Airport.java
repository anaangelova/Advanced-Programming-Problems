package Exercises_For_Second_PartialExam.Aerodromi;

import java.util.*;

public class Airport {
    String name;
    String country;
    String code;
    int passengers;
    Map<String, TreeSet<Flight>> flightsByDestination;
    Set<Flight> allFlightsTo;

    public Airport(String name, String country, String code, int passengers) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.passengers = passengers;
        this.flightsByDestination = new HashMap<>();
        this.allFlightsTo = new TreeSet<>(Comparator.comparing(Flight::getTime2).thenComparing(Flight::getDuration));
    }

    @Override
    public String toString() {
        return String.format("%s (%s)\n%s\n%d", name, code, country, passengers);
    }
}