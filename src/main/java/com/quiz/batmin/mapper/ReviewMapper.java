package com.quiz.batmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.batmin.domain.Review;

@Mapper
public interface ReviewMapper {
	
	public List<Review> selectReviewListByStoreId(int id);
}
