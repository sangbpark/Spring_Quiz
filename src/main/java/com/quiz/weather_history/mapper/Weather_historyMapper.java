package com.quiz.weather_history.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.Weather_history;

@Mapper
public interface Weather_historyMapper {
	
	public List<Weather_history> selectWeather_historyList();
	
	public int insertWeather_history(
			@Param("date") LocalDate date, 
			@Param("weather") String weather,
			@Param("microDust") String microDust, 
			@Param("temperatures") double temperatures, 
			@Param("precipitation") double precipitation, 
			@Param("windSpeed") double windSpeed);

}
