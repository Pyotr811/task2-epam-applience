package by.epam.home.dao;

import by.epam.home.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceFactory {
    public Appliance getObjectFromString(String appliance) {
        switch (appliance.split("\\s")[0]) {
            case "Oven":
                return createOven(appliance);
            case "TabletPC":
                return createTabletPc(appliance);
            case "Laptop":
                return createLaptop(appliance);
            case "Kettle":
                return createKettle(appliance);
            default:
                return null;
        }
    }

    private Oven createOven(String stringView) {
        double power = parseDouble(getFieldObject("POWER_CONSUMPTION", stringView));
        double weight = parseDouble(getFieldObject("WEIGHT", stringView));
        double capacity = parseDouble(getFieldObject("CAPACITY", stringView));
        double depth = parseDouble(getFieldObject("DEPTH", stringView));
        double height = parseDouble(getFieldObject("HEIGHT", stringView));
        double width = parseDouble(getFieldObject("WIDTH", stringView));
        double price = parseDouble(getFieldObject("PRICE", stringView));
        return new Oven(power, weight, capacity, depth, height, width, price);
    }

    private TabletPC createTabletPc(String stringView) {
        double batteryCapacity = parseDouble(getFieldObject("BATTERY_CAPACITY", stringView));
        double displayInches = parseDouble(getFieldObject("DISPLAY_INCHES", stringView));
        double memoryRom = parseDouble(getFieldObject("MEMORY_ROM", stringView));
        double flashMemoryCapacity = parseDouble(getFieldObject("FLASH_MEMORY_CAPACITY", stringView));
        String color = getFieldObject("COLOR", stringView);
        double price = parseDouble(getFieldObject("PRICE", stringView));
        return new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color, price);
    }

    private Kettle createKettle(String stringView) {
        double power = parseDouble(getFieldObject("POWER", stringView));
        double capacity = parseDouble(getFieldObject("CAPACITY", stringView));
        String color = getFieldObject("COLOR", stringView);
        double weight = parseDouble(getFieldObject("WEIGHT", stringView));
        double price = parseDouble(getFieldObject("PRICE", stringView));
        return new Kettle(power, capacity, color, weight, price);
    }

    private Laptop createLaptop(String stringView) {
        double batteryCapacity = parseDouble(getFieldObject("BATTERY_CAPACITY", stringView));
        String OS = getFieldObject("OS", stringView);
        int memoryRom = parseInt(getFieldObject("MEMORY_ROM", stringView));
        int systemMemory = parseInt(getFieldObject("SYSTEM_MEMORY", stringView));
        double cpu = parseDouble(getFieldObject("CPU", stringView));
        double displayInches = parseDouble(getFieldObject("DISPLAY_INCHS", stringView));
        double price = parseDouble(getFieldObject("PRICE", stringView));
        return new Laptop(batteryCapacity, OS, memoryRom, systemMemory, cpu, displayInches, price);
    }

    private double parseDouble(String value) {
        if (value == null) {
            return 0;
        } else if (value.matches("\\d+(\\.\\d+)?")) {
            return Double.parseDouble(value);
        }
        return 0;
    }

    private int parseInt(String value) {
        if (value == null) {
            return 0;
        } else if (value.matches("\\d+")) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    private String getFieldObject(String param, String line) {
        Pattern pattern = Pattern.compile(param + "=(\\S+)((,)|$)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
