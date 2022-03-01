package com.weather.prediction.entity;

public class NextDayForecast {
	private String action;
	private int avgHumidity;
	private double maxTemp;
	private String dateText;
	private double wind;

	public NextDayForecast(String dateText, int avgHumidity, double maxTemp, double wind) {
		this.dateText = dateText;
		this.avgHumidity = avgHumidity;
		this.maxTemp = maxTemp;
		this.wind = wind;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getAvgHumidity() {
		return avgHumidity;
	}

	public void setAvgHumidity(int avgHumidity) {
		this.avgHumidity = avgHumidity;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public double getWind() {
		return wind;
	}

	public void setWind(double wind) {
		this.wind = wind;
	}

}