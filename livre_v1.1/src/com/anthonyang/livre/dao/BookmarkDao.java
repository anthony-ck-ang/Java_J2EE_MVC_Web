package com.anthonyang.livre.dao;

import com.anthonyang.livre.DataStore;
import com.anthonyang.livre.entities.Bookmark;
import com.anthonyang.livre.entities.UserBookmark;

public class BookmarkDao {
	/*
	 * This is for the datastore implementation.  
	 * Version 2 will change with the database implementation
	 */
	public Bookmark[][] getBookmark() {
	 return DataStore.getBookmarks();
 }
	//Dao -> DataStore
	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
