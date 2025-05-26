package com.example.wheatherApp.model;

import java.util.Objects;

public class City {
    private final String name;
    private final int rank;

    public City(String name, int rank) {
        this.name = Objects.requireNonNull(name, "name");
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }
}
