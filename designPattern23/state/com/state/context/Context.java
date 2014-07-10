package com.state.context;

import com.state.state.Weather;

public class Context {
	
	private Weather weather;

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	
	public String weatherMessage(){
		return weather.getWeather();
	}

}
