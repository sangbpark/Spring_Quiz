package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {
	
	// 회원가입 화면
	// /sing-up-view
	@GetMapping("/sing-up-view")
	public String singUpView() {
		return "lesson06/singUp";
	}
	
}
