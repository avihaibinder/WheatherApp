package com.example.wheatherApp.service;

import com.example.wheatherApp.jsonparser.CityParser;
import com.example.wheatherApp.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final HttpService httpService;

    public CityService(HttpService httpService) {
        this.httpService = httpService;
    }

    public List<City> fetchCities() throws Exception {
        String body = httpService.fetch("http://weather-automation-checkpoint-task.westeurope.cloudapp.azure.com:3000/cities");
        return CityParser.parse(body);
    }
}
