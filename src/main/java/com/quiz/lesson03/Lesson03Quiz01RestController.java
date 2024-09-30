package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;

	@RequestMapping("/1")
	public RealEstate quiz01(
			@RequestParam("id") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	@RequestMapping("/2")
	public List<RealEstate> quiz02(
			@RequestParam("rent_price") Integer rent_price) {
		return realEstateBO.getRealEstateListByRentPrice(rent_price);
	}
	
	@RequestMapping("/3")
	public List<RealEstate> quiz03(
			@RequestParam("area") int area,
			@RequestParam("price") int price) {
		return realEstateBO.getRealEstateListByAreaByPrice(area, price);
	}
}
