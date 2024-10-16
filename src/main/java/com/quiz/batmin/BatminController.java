package com.quiz.batmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RequestMapping("/batmin")
@Controller
public class BatminController {
	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store-view")
	public String storeView(Model model) {
		List<Store> store = storeBO.getStoreList();
		model.addAttribute("store", store);
		return "batmin/storeView";
	};
}
