package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.Weather_history;
import com.quiz.weather_history.mapper.Weather_historyMapper;

@Service
public class Weather_historyBO {
	@Autowired
	private Weather_historyMapper weather_historyMapper;

	public List<Weather_history> getWeather_historyList() {
		return weather_historyMapper.selectWeather_historyList();
	};
}
