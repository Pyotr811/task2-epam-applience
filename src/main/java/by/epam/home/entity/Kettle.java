package by.epam.home.entity;

import java.util.Objects;

public class Kettle extends Appliance{
    private double power;
    private double capacity;
    private String color;
    private double weight;

    public Kettle(){
    }

    public Kettle(double power, double capacity, String color, double weight, double price) {
        super(price);
        this.power = power;
        this.capacity = capacity;
        this.color = color;
        this.weight = weight;

    }

    public double getPower() {
        return power;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Kettle kettle = (Kettle) o;
        return Double.compare(kettle.power, power) == 0 &&
                Double.compare(kettle.capacity, capacity) == 0 &&
                Double.compare(kettle.weight, weight) == 0 &&
                Objects.equals(color, kettle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), power, capacity, color, weight);
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "power=" + power +
                ", capacity=" + capacity +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + getPrice() +
                '}';
    }
}
