package com.anthonyang.livre.entities;

public class UserBookmark {
	private User user;
	private Bookmark bookmark;

	/*
	 * if a user bookmarks anything, it will be stored in this class.
	 * if there is database, a separate table will be created for this entity.
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
}
