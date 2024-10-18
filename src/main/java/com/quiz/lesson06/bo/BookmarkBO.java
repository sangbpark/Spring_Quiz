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
	
	public boolean isDuplicatedUrl(String url) {
		if (bookmarkMapper.isDuplicatedUrl(url) > 0) {
			return true;
		}
		return false;	
	};
	
	public Boolean removeBookmark(String url) {
		if (bookmarkMapper.deleteBookmark(url) > 0) {
			return true;
		}
		return false;
	};
}
