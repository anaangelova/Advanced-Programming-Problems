package Exercises_For_Second_PartialExam.Stadium;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sector {
    String code;
    int capacity;
    Map<Integer, Seat> seatsMap;

    public Sector(String code, int capacity) {
        this.capacity = capacity;
        this.code = code;

        this.seatsMap = new TreeMap<>();
        IntStream.range(0, capacity).forEach(el -> seatsMap.put(el + 1, new Seat()));
    }

    private float getPercentage() {
        return 100 - (getFreeSeats() / (float) capacity) * 100;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d/%d\t%.1f%%", code, getFreeSeats(), capacity, getPercentage());
    }

    public String getCode() {
        return code;
    }

    public List<Integer> getTypeSeats() {
        return seatsMap.values().stream().map(seat -> seat.type).distinct().collect(Collectors.toList());
    }

    public int getFreeSeats() {
        return (int) seatsMap.values().stream().filter(seat -> !seat.taken).count();
    }
}