package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private BookmarkBO bookmarkBO;
	
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/bookmarkAddView";
	}
	
	// 추가 기능 => AJAX 호출
	// @ResponseBody가 사용되면 Model을 쓸 수 없다.
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		bookmarkBO.addBookmark(name, url);
		// 성공 여부 JSON String
		// "{"code":200, "result":"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView(Model model) {
		
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarks", bookmarkList);
		return "lesson06/bookmarkView";
	}
	
	@ResponseBody
	@PostMapping("/url-duplicate")
	public Map<String, Object> isDuplicateUrl(
			@RequestParam("url") String url) {
		
		boolean isDuplicateUrl = bookmarkBO.isDuplicateUrl(url);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicate_url", isDuplicateUrl);
		return result;
	}
	
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		boolean isDeleted = bookmarkBO.deleteBookmarkById(id);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_deleted_bookmark", isDeleted);
		return result;
	}
}
