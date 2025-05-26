package com.example.wheatherApp;

import com.example.wheatherApp.model.City;
import com.example.wheatherApp.model.CityAndTemperature;
import com.example.wheatherApp.service.CityService;
import com.example.wheatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WheatherAppApplication implements CommandLineRunner {

	@Autowired
	private CityService cityService;

	@Autowired
	private WeatherService weatherService;

	public static void main(String[] args) {
		SpringApplication.run(WheatherAppApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			List<City> cities = cityService.fetchCities();
			List<CityAndTemperature> citiesAndTemperatures = new ArrayList<>();
			for (City city : cities) {
				double temperature = weatherService.fetchWeather(city);
				if (temperature < 0) {
					continue;
				}
				citiesAndTemperatures.add(new CityAndTemperature(city, temperature));
			}
			for (CityAndTemperature entry : citiesAndTemperatures) {
				System.out.printf("%s : %.1f°C%n", entry.getName(), entry.getTemperature());
			}
		} catch (Exception e) {
			System.out.println("Failed to fetch weather data: " + e.getMessage());
		}
	}
}
