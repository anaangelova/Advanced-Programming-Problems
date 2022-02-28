package Exercises_For_Second_PartialExam.KalendarNaNastani;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

public class Event{
    String eventName;
    String eventLocation;


    LocalDateTime date;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, YYY HH:mm", Locale.US);

    public static Comparator<Event> comparator=Comparator.comparing(Event::getDate).thenComparing(Event::getEventName);
    public Event(String eventName,String eventLocation,LocalDateTime date){
        this.eventName=eventName;
        this.eventLocation=eventLocation;
        this.date=date;
    }

    @Override
    public String toString() {
        return String.format("%s at %s, %s", date.format(formatter), eventLocation, eventName);
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}