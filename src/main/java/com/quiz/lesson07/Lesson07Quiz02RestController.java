package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	@Autowired
	private RecruitRepository recuritRepository;
	
	@GetMapping("/1")
	public RecruitEntity select1() {
		return recuritRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyid) {
		return recuritRepository.findByCompanyId(companyid);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recuritRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		return recuritRepository.findByTypeAndSalaryGreaterThanEqual("정규직", 7000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recuritRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> select6() {
		return recuritRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
}
