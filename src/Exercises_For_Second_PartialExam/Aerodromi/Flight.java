package Exercises_For_Second_PartialExam.Aerodromi;

public class Flight implements Comparable<Flight> {

    String fromCode;
    String toCode;
    int time;
    int duration;

    public Flight(String fromCode, String toCode, int time, int duration) {
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.time = time;
        this.duration = duration;
    }

    @Override
    public int compareTo(Flight o) {
        return Integer.compare(this.time, o.time);
    }
    //LHR;ATL;764;291 sample input
    //LHR-ATL 12:44-17:35 4h51m sample output

    //LAS;DEN;1378;176
    //LAS-DEN 22:58-01:54 +1d 2h56m
    public String getTime() {
        //12:44 from
        int hourFrom = this.time / 60;
        int minFrom = this.time % 60;

        //17:35 to
        int hourTo = (this.duration + this.time) / 60;
        int minTo = (this.duration + this.time) % 60;
        int durationMin = (hourTo * 60 + minTo) - this.time;
        if (hourTo >= 24) {
            hourTo = hourTo % 24;
            return String.format("%02d:%02d-%02d:%02d +1d %dh%02dm", hourFrom, minFrom, hourTo, minTo, durationMin / 60, durationMin % 60);
        } else {
            return String.format("%02d:%02d-%02d:%02d %dh%02dm", hourFrom, minFrom, hourTo, minTo, durationMin / 60, durationMin % 60);
        }

    }

    public int getTime2() {
        return this.time;
    }

    public String getToCode() {
        return toCode;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s-%s %s", fromCode, toCode, getTime());
    }
}