package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateListByRentPrice(Integer rentPrice);
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			// 파라미터를 두개 이상 xml에 보낼 수 없다. 
			// 하나의 맵으로 구성해야 하는데, @Param이 맵으로 만들어줌
			@Param("area")int area, 
			@Param("price")int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area,
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
}
