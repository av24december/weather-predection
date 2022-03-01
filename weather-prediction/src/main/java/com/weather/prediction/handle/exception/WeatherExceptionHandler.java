package com.weather.prediction.handle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

import com.weather.prediction.error.WeatherDataParseException;
import com.weather.prediction.error.WeatherError;

@ControllerAdvice
public class WeatherExceptionHandler {

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
