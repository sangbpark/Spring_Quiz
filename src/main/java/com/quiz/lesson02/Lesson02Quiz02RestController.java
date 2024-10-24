package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController
public class Lesson02Quiz02RestController {
	
	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/lesson02/quiz02")
	public List<Store> quiz02() {
		return storeBO.getStoreList();
	}
}
