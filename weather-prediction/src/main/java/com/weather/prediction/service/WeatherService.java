package com.weather.prediction.service;

import com.weather.prediction.entity.Weather;

public interface WeatherService {
	public Weather getWeatherForCity(String city);
}