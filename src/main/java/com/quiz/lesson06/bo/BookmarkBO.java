package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;

	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	};
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	};
	
	public boolean isDuplicateUrl(String url) {
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkByUrl(url);
		
		return bookmarkList.isEmpty() == false;
	};
	
	public Boolean deleteBookmarkById(int id) {
		if (bookmarkMapper.deleteBookmarkById(id) > 0) {
			return true;
		}
		return false;
	};
}
