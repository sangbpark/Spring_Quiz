package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {
	@Autowired
	private CompanyBO companyBO;

	@GetMapping("/save1")
	public CompanyEntity save1() {
		return companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateCompanyById(6, "중소기업", 37);
	}
	
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteCompanyById(8);
		return "성공";
	}
}
