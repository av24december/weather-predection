
package com.weather.prediction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.weather.prediction.entity.Weather;
import com.weather.prediction.error.WeatherDataParseException;
import com.weather.prediction.error.WeatherError;
import com.weather.prediction.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService service;

	@GetMapping("/{cityname}")
	public Weather getWeatherInfo(@PathVariable("cityname") String city) {
		return service.getWeatherForCity(city);
	}

	@ExceptionHandler
	public ResponseEntity<WeatherError> handleException(WeatherDataParseException e) {
		WeatherError error = new WeatherError();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		error.setMessage(e.getMessage());

		return ResponseEntity.internalServerError().body(error);
	}

	@ExceptionHandler
	public ResponseEntity<WeatherError> handleException(RestClientException e) {
		WeatherError error = new WeatherError();
		error.setStatus(HttpStatus.BAD_REQUEST);
		error.setMessage(e.getMessage());

		return ResponseEntity.badRequest().body(error);
	}
}
