package Exercises_For_First_Partial_Exam.F1Race;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class F1Test {

    public static void main(String[] args) {
        F1Race f1Race = new F1Race();
        f1Race.readResults(System.in);
        f1Race.printSorted(System.out);
    }

}
class Driver implements Comparable<Driver> {
    String name;
    List<String> laps;
    String bestTime;

    public Driver(String name, List<String> laps) {
        this.name = name;
        this.laps = laps;
        if(laps.get(0).compareTo(laps.get(1))<0){
            if(laps.get(0).compareTo(laps.get(2))<0)
                this.bestTime=laps.get(0);
            else this.bestTime=laps.get(2);
        }else{
            if(laps.get(1).compareTo(laps.get(2))<0){
                this.bestTime=laps.get(1);
            }else this.bestTime=laps.get(2);
        }
    }

    public Driver() {
        this.laps = new ArrayList<>();
    }

    public static Driver createDriver(String line) {
        String[] parts = line.split("\\s+");
        String name = parts[0];
        List<String> laps = new ArrayList<>();
        laps.add(parts[1]);
        laps.add(parts[2]);
        laps.add(parts[3]);
        return new Driver(name, laps);
    }


    @Override
    public int compareTo(Driver o) {
        if(this.bestTime.compareTo(o.bestTime)<0)
            return -1;
        else if(this.bestTime.compareTo(o.bestTime)==0)
            return 0;
        return 1;
    }

}
class F1Race {
    List<Driver> drivers;
    public F1Race(){
        this.drivers=new ArrayList<>();
    }
    public void readResults(InputStream inputStream){
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        drivers=br.lines().map(line -> Driver.createDriver(line)).collect(Collectors.toList());

    }
    public void printSorted(OutputStream outputStream){
        PrintWriter pw=new PrintWriter(outputStream);
        Collections.sort(drivers);
        drivers.forEach(new Consumer<Driver>() {
            int i = 1;
            @Override
            public void accept(Driver driver) {
                pw.printf("%d. %-10s%10s\n", i, driver.name, driver.bestTime);
                i++;
            }
        });
        pw.flush();
    }

}