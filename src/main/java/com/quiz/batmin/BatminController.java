package com.quiz.batmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.batmin.bo.ReviewBO;
import com.quiz.batmin.dto.FindReviewDto;
import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RequestMapping("/batmin")
@Controller
public class BatminController {
	@Autowired
	private StoreBO storeBO;
	@Autowired
	private ReviewBO reviewBO;
	
	@GetMapping("/store-view")
	public String storeView(Model model) {
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("stores", storeList);
		return "batmin/storeView";
	};
	
	@GetMapping("/reviews")
	public String storeReivews(
			@RequestParam("storeId") int id,
			@RequestParam("storeName") String name,
			Model model) {
		List<FindReviewDto> reviewList = reviewBO.getReviewListByStoreId(id);
		model.addAttribute("reviews", reviewList);
		model.addAttribute("storeName", name);
		return "batmin/storeReview";
	}
}
