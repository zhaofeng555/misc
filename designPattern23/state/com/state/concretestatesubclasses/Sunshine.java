package com.state.concretestatesubclasses;

import com.state.state.Weather;

public class Sunshine implements Weather {

	@Override
	public String getWeather() {
		return "阳光";
	}

}
