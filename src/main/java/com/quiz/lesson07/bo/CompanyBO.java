package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity addCompany (String name, String business, 
			String scale, int headcount) {
		return companyRepository.save(CompanyEntity.builder()
				.name(name).business(business)
				.scale(scale).headcount(headcount).build());
	}
	
	public CompanyEntity updateCompanyById (int id, String scale, int headcount) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
	
		return companyOptional.map(c -> companyRepository.save(c.toBuilder().scale(scale).headcount(headcount).build())).orElse(null);
	}
	
	public void deleteCompanyById (int id) {
		Optional<CompanyEntity> companyOtional = companyRepository.findById(id);
		companyOtional.ifPresent(c ->companyRepository.deleteById(c.getId()));
	}
}
