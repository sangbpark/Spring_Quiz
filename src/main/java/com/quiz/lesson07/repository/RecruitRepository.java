package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {

	public List<RecruitEntity> findByCompanyId(int companyId);
	
	public List<RecruitEntity> findByPositionAndType(String positon, String type);
	
	public List<RecruitEntity> findByTypeAndSalaryGreaterThanEqual(String type, int greaterThanEqual);
	
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);
}
