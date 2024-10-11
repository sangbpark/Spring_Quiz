package com.quiz.lesson04.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.Realtor;

@Mapper
public interface RealtorMapper {

	public int insertRealtor(Realtor realtor);
	
	public int insertRealtorTest(Map<String, Object> realtor);
	
	public Realtor selectRealtorById(int id);
}
