package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weather_history.domain.Weather_history;

@Mapper
public interface Weather_historyMapper {
	
	public List<Weather_history> selectWeather_historyList();

}
