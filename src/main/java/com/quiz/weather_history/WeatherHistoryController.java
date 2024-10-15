package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.Weather_historyBO;
import com.quiz.weather_history.domain.Weather_history;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private Weather_historyBO weather_historyBO;

	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		List<Weather_history> weather_history = weather_historyBO.getWeather_historyList();
		model.addAttribute("weatherhistory", weather_history);
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add-weather")
	public String addweather() {
		
		return "weather_history/weatherList";
	}
}
