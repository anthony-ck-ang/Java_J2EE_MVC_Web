package com.anthonyang.livre;

import com.anthonyang.livre.entities.Bookmark;
import com.anthonyang.livre.entities.User;
import com.anthonyang.livre.managers.BookmarkManager;
import com.anthonyang.livre.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	public static void main(String[] args) {

		loadData();
		requestData();
		printData();
		
		start();
	}

	private static void start() {
		System.out.println("\n2. Bookmarking...");
		for (User user : users) {
			View.browse(user, bookmarks);
		}
	}

	private static void loadData() {
		System.out.println("1. Loading data...");
		DataStore.loadData();
	}

	private static void requestData() {
		System.out.println("Requesting data...");
		users = UserManager.getInstance().getUser();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
	}

	private static void printData() {
		System.out.println("Printing data...");
		printUserData();
		printBookmarkData();
	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}

}
