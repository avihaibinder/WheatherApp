package com.example.wheatherApp.service;

import com.example.wheatherApp.model.City;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Value("${api.key}")
    private String apiKey;

    private final HttpService httpService;

    public WeatherService(HttpService httpService) {
        this.httpService = httpService;
    }

    public double fetchWeather(City city) {
        try {
            String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
            String url = String.format(API_URL, city.getName().replace(" ", "%20"), apiKey);
            String responseBody = httpService.fetch(url);
            JSONObject json = new JSONObject(responseBody);
            if (json.has("main")) {
                return json.getJSONObject("main").getDouble("temp");
            }

        } catch (Exception e) {
            System.out.printf("%s : [FAILED] %s%n", city.getName(), e.getMessage());
        }
        return -1;
    }
}