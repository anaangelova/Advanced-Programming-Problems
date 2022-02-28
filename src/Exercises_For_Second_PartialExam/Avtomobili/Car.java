package Exercises_For_Second_PartialExam.Avtomobili;

import java.util.Comparator;

public class Car{
    String manufacturer;
    String model;
    int price;
    float power;

    public static Comparator<Car> comparator=Comparator.comparing(Car::getPrice).thenComparing(Car::getPower);
    public Car(String manufacturer, String model, int price, float power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public float getPower() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%dKW) %d",manufacturer,model,(int)power,price);
    }
}