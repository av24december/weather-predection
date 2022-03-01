
package com.weather.prediction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weather.prediction.entity.Weather;
import com.weather.prediction.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService service;

	@GetMapping("/{cityname}")
	public Weather getWeatherInfo(@PathVariable("cityname") String city) {
		return service.getWeatherForCity(city);
	}

}
