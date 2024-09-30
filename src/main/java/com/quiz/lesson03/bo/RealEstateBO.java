package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateListByRentPrice(Integer rent_price) {
		return realEstateMapper.selectRealEstateListByRentPrice(rent_price);
	}
	
	public List<RealEstate> getRealEstateListByAreaByPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaByPrice(area, price);
	}
}
