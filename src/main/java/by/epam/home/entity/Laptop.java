package by.epam.home.entity;

import java.util.Objects;

public class Laptop extends Appliance{
    private double batteryCapacity;
    private String OS;
    private int memoryRom;
    private int systemMemory;
    private double CPU;
    private double displayInches;

    public Laptop() {
    }

    public Laptop(double batteryCapacity, String OS, int memoryRom, int systemMemory, double CPU,
                  double displayInches, double price) {
        super(price);
        this.batteryCapacity = batteryCapacity;
        this.OS = OS;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayInches = displayInches;

    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOS() {
        return OS;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public double getCPU() {
        return CPU;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 &&
                memoryRom == laptop.memoryRom &&
                systemMemory == laptop.systemMemory &&
                Double.compare(laptop.CPU, CPU) == 0 &&
                Double.compare(laptop.displayInches, displayInches) == 0 &&
                Objects.equals(OS, laptop.OS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity, OS, memoryRom, systemMemory, CPU, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", OS='" + OS + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", CPU=" + CPU +
                ", displayInches=" + displayInches +
                ", price=" + getPrice() +
                '}';
    }
}
