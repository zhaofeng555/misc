package com.state.concretestatesubclasses;

import com.state.state.Weather;

public class Rain implements Weather {

	@Override
	public String getWeather() {
		return "下雨";
	}

}
