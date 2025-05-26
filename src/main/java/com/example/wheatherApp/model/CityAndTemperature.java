package com.example.wheatherApp.model;

public class CityAndTemperature extends City {
    double temperature;

    public CityAndTemperature(City city, double temp) {
        super(city.getName(), city.getRank());
        this.temperature = temp;
    }

    public double getTemperature() {
        return temperature;
    }
}
