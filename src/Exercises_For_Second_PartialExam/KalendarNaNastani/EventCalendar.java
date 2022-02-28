package Exercises_For_Second_PartialExam.KalendarNaNastani;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class EventCalendar{
    int year;
    Map<Integer, List<Event>> eventsByDate;
    Map<Integer,Integer> noEventsByMonth;

    public EventCalendar(int year) {
        this.year = year;
        this.eventsByDate=new HashMap<>();
        this.noEventsByMonth=new TreeMap<>(Comparator.naturalOrder());
        IntStream.range(1,13).forEach(i -> noEventsByMonth.put(i,0));
    }


    public void addEvent(String name, String location, LocalDateTime date) throws WrongDateException {
        if(date.getYear()!=this.year)
            throw new WrongDateException(date);

        eventsByDate.putIfAbsent(date.getDayOfYear(),new ArrayList<>());
        eventsByDate.computeIfPresent(date.getDayOfYear(), (k,v) -> {
            v.add(new Event(name,location,date));
            return v;
        });


        noEventsByMonth.computeIfPresent(date.getMonthValue(), (k,v) -> {
            v=v+1;
            return v;
        });

    }

    public void listEvents(LocalDateTime date) {
        if(eventsByDate.containsKey(date.getDayOfYear())){
            eventsByDate.get(date.getDayOfYear()).stream().sorted(Event.comparator).forEach(e -> System.out.println(e));
            return;
        }
        System.out.println("No events on this day!");

    }

    public void listByMonth() {
        noEventsByMonth.entrySet().stream().forEach(e -> System.out.println(String.format("%d : %d",e.getKey(),e.getValue())));
    }
}
