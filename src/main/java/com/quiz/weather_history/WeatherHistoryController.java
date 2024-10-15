package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	@GetMapping("/weather-list-view")
	public String weatherListView() {
		
		return "weather_history/weatherList";
	}
}
