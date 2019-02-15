package com.anthonyang.controllers;

import com.anthonyang.livre.entities.Bookmark;
import com.anthonyang.livre.entities.User;
import com.anthonyang.livre.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		return instance;
	}
	
	//Controller -> Manager
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}
	
	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);	
	}
	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);		
	}
}
