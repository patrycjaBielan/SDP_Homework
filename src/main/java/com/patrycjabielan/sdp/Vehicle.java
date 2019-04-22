package com.patrycjabielan.sdp;

public class Vehicle {
    private String manufacturer;
    private int maxSpeed;

    public Vehicle(String manufacturer, int maxSpeed) {
        this.manufacturer = manufacturer;
        this.maxSpeed = maxSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
