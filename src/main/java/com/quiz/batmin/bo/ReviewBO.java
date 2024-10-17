package com.quiz.batmin.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.batmin.domain.Review;
import com.quiz.batmin.dto.FindReviewDto;
import com.quiz.batmin.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<FindReviewDto> getReviewListByStoreId(int id) {
		List<Review> review = reviewMapper.selectReviewListByStoreId(id);
		List<FindReviewDto> frdList = new ArrayList<>();
		
		if (!review.isEmpty()) {
			for (Review temp : review) {
				FindReviewDto frd = new FindReviewDto();
				frd.setMenu(temp.getMenu());
				frd.setPoint(pointDivision(temp.getPoint()));
				frd.setReview(temp.getReview());
				frd.setUserName(temp.getUserName());
				frd.setUpdatedAt(temp.getUpdatedAt());
				frdList.add(frd);
			}
		}
		return frdList;
	};
	
	public List<Double> pointDivision(double point) {
		List<Double> points = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			if (point - i >= 1) {
				points.add(1.0);
			} else if (point - i == 0.5) {
				points.add(0.5);
			} else {
				points.add(0.0);
			}
		}
		return points;
	};
}
