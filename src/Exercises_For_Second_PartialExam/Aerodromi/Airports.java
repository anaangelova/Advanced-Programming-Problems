package Exercises_For_Second_PartialExam.Aerodromi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Airports {

    Map<String, Airport> allAirports;

    public Airports() {
        this.allAirports = new HashMap<>();
    }

    public void addAirport(String name, String country, String code, int passengers) {
        allAirports.putIfAbsent(code, new Airport(name, country, code, passengers));
    }

    public void addFlights(String from, String to, int time, int duration) {
        allAirports.computeIfPresent(from, (key, value) -> {
            value.flightsByDestination.putIfAbsent(to, new TreeSet<>(Comparator.comparing(Flight::getToCode).thenComparing(Flight::getTime2)));
            value.flightsByDestination.computeIfPresent(to, (k, val) -> {
                val.add(new Flight(from, to, time, duration));
                return val;
            });
            return value;
        });
        allAirports.computeIfPresent(to, (k, v) -> {
            v.allFlightsTo.add(new Flight(from, to, time, duration));
            return v;
        });
    }

    public void showFlightsFromAirport(String code) {
        System.out.println(allAirports.get(code));
        List<Flight> allFlights = allAirports.get(code)
                .flightsByDestination.values()
                .stream()
                .flatMap(set -> set.stream())
                .sorted(Comparator.comparing(Flight::getToCode).thenComparing(Flight::getTime2))
                .collect(Collectors.toList());
        IntStream.range(0, allFlights.size()).forEach(flight -> System.out.printf("%d. %s\n", flight + 1, allFlights.get(flight)));
    }

    public void showDirectFlightsFromTo(String from, String to) {
        if (allAirports.get(from).flightsByDestination.get(to) != null) {
            allAirports.get(from).flightsByDestination.get(to).stream().forEach(flight -> System.out.println(flight));
        } else System.out.printf("No flights from %s to %s\n", from, to);
    }

    public void showDirectFlightsTo(String to) {
        allAirports.get(to).allFlightsTo.stream().forEach(flight -> System.out.println(flight));
    }
}
