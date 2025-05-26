package com.example.wheatherApp.jsonparser;

import com.example.wheatherApp.model.City;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class CityParser {
    public static List<City> parse(String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONArray citiesArray = jsonObject.getJSONArray("cities");
        Set<String> visited = new HashSet<>();
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < citiesArray.length(); i++) {
            JSONObject curCityJson = citiesArray.getJSONObject(i);
            String name = curCityJson.getString("name").trim();
            if (name.isEmpty() || visited.contains(name)) {
                continue;
            }
            visited.add(name);
            int rank = curCityJson.getInt("rank");
            cities.add(new City(name, rank));
        }
        return cities;
    }
}
