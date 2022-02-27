package Exercises_For_First_Partial_Exam.DailyTemperatures;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

abstract class Temperature { //24C 46F
    int temperature;

    public Temperature(int temperature) {
        this.temperature = temperature;
    }


    public static Temperature createTemperature(String part) { //factory design pattern
        //29C
        char type = part.charAt(part.length() - 1);
        int value = Integer.parseInt(part.substring(0, part.length() - 1));
        if (type == 'C')
            return new CelsiusTemp(value);
        else
            return new FahrenheitTempt(value);
    }

    public abstract double getTemperatureC();

    public abstract double getTemperatureF();
}

class CelsiusTemp extends Temperature {

    public CelsiusTemp(int value) {
        super(value);
    }

    @Override
    public double getTemperatureC() {
        return temperature;
    }

    @Override
    public double getTemperatureF() {
        return (temperature * 9) / 5.0 + 32;
    }
}

class FahrenheitTempt extends Temperature {

    public FahrenheitTempt(int temperature) {
        super(temperature);
    }

    @Override
    public double getTemperatureF() {
        return temperature;
    }

    @Override
    public double getTemperatureC() {
        return (temperature - 32) * 5 / 9.0;
    }
}

class Day implements Comparable<Day> {

    int day;
    List<Temperature> temperatures;

    public Day(int day, List<Temperature> temperatures) {
        this.day = day;
        this.temperatures = temperatures;
    }

    public static Day createDay(String line) { //317 24C 29C 28C 29C
        String[] parts = line.split("\\s+");
        int day = Integer.parseInt(parts[0]);
        List<Temperature> temperatures = Arrays.stream(parts).skip(1)
                .map(part -> Temperature.createTemperature(part))
                .collect(Collectors.toList());

        return new Day(day, temperatures);
    }

    public void printStats(OutputStream out, char scale) {
        PrintWriter pw = new PrintWriter(out);
        DoubleSummaryStatistics dss = temperatures
                .stream().mapToDouble(temp -> scale == 'C' ? temp.getTemperatureC() : temp.getTemperatureF())
                .summaryStatistics();
        pw.printf("%3d: Count: %3d Min: %6.2f%c Max: %6.2f%c Avg: %6.2f%c\n", day, dss.getCount(), dss.getMin(), scale,
                dss.getMax(), scale, dss.getAverage(), scale);
        pw.flush();
    }

    @Override
    public int compareTo(Day o) {
        return Integer.compare(this.day, o.day);
    }
}

class DailyTemperatures {
    List<Day> days;

    public DailyTemperatures() {
        this.days = new ArrayList<>();
    }


    public void readTemperatures(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        days = br.lines().map(line -> Day.createDay(line)).collect(Collectors.toList());
    }

    public void writeDailyStats(OutputStream out, char scale) {
        days.stream().sorted(Comparator.naturalOrder()).forEach(day -> day.printStats(out, scale));

    }

}

public class DailyTemperatureTest {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        dailyTemperatures.readTemperatures(System.in);
        System.out.println("=== Daily temperatures in Celsius (C) ===");
        dailyTemperatures.writeDailyStats(System.out, 'C');
        System.out.println("=== Daily temperatures in Fahrenheit (F) ===");
        dailyTemperatures.writeDailyStats(System.out, 'F');
    }
}
