package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.Weather_historyBO;
import com.quiz.weather_history.domain.Weather_history;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private Weather_historyBO weather_historyBO;
	
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		List<Weather_history> weather_historyList = weather_historyBO.getWeather_historyList();
		model.addAttribute("weatherhistoryList", weather_historyList);
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add-weather")
	public String addweather( // @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
			@RequestParam("date") LocalDate date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
			) {
		weather_historyBO.addWeather_history(date, weather, microDust, temperatures, precipitation, windSpeed);
		return "redirect:/weather_history/weather-list-view";
	}
}
