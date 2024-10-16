package com.quiz.lesson04;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// /lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature
			) {
		// TODO 아직 할게 있다면 이런 주석을 남김
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model, 
			@RequestParam("id") Optional<Integer> id) {// Optional null확인 spring에서 Optional을 사용하면 required쓸 필요없음
		// 메소드 참조 sellerBO::
		Seller seller = id.map(sellerBO::getSellerById). // or (value -> sellerBO.getSellerById(value))
				orElseGet(sellerBO::getLatestSeller); // or (() -> sellerBO.getSellerRecentlyInsert())
	
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
	
		return "lesson04/sellerInfo";
	}
}
