package Exercises_For_Second_PartialExam.Stadium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stadium {
    String name;
    Map<String, Sector> sectorsMap;

    public Stadium(String name) {
        this.name = name;
        this.sectorsMap = new HashMap<>();
    }

    public void createSectors(String[] sectorNames, int[] sizes) {
        for (int i = 0; i < sectorNames.length; i++) {
            sectorsMap.putIfAbsent(sectorNames[i], new Sector(sectorNames[i], sizes[i]));
        }
        //mapata so sektori e popolneta, sekoj sektor mozhe da se najde preku negoviot kod
    }

    public void buyTicket(String sectorName, int seat, int type) throws SeatTakenException, SeatNotAllowedException {
        boolean occupied = sectorsMap.get(sectorName).seatsMap.get(seat).taken;
        List<Integer> typeSeats = sectorsMap.get(sectorName).getTypeSeats();
        if (occupied) throw new SeatTakenException("SeatTakenException");
        if ((type == 1 && typeSeats.contains(2)) || (type == 2 && typeSeats.contains(1)))
            throw new SeatNotAllowedException("SeatNotAllowedException");
        //mozhe da go kupe biletot znachi treba da se oznachi deka vekje mestoto e zafateno
        sectorsMap.get(sectorName).seatsMap.computeIfPresent(seat, (key, value) -> {
            value.type = type;
            value.taken = true;
            return value;
        });
    }

    public void showSectors() {
        sectorsMap.values().stream().sorted(Comparator.comparing(Sector::getFreeSeats).reversed().thenComparing(Sector::getCode))
                .forEach(System.out::println);
    }

}
