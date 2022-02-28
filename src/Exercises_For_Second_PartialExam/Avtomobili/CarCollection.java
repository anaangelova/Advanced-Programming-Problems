package Exercises_For_Second_PartialExam.Avtomobili;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getList() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void sortByPrice(boolean ascending) {
        if (ascending) {
            cars.sort(Car.comparator);
            return;
        }
        cars.sort(Car.comparator.reversed());

    }

    public List<Car> filterByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.manufacturer.equalsIgnoreCase(manufacturer))
                .sorted(Comparator.comparing(Car::getModel))
                .collect(Collectors.toList());
    }
}