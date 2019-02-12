package com.anthonyang.livre;

import com.anthonyang.controllers.BookmarkController;
import com.anthonyang.livre.constants.KidFriendlyStatus;
import com.anthonyang.livre.constants.UserType;
import com.anthonyang.livre.entities.Bookmark;
import com.anthonyang.livre.entities.User;
import com.anthonyang.livre.partner.Shareable;

public class View {
	/*
	 * This simulates the user selecting in the browser (UI/view) randomly. The
	 * methods here will be invoked in the Launch class. UI will send request to
	 * controller.
	 */

	public static void browse(User user, Bookmark[][] bookmarkTable) {
		System.out.println("\n" + user.getEmail() + " is browsing items...");
		int bookmarkCount = 0;

		// user will iterate through all the list
		for (Bookmark[] bookmarkList : bookmarkTable) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision();
					if (isBookmarked) {
						// user bookmarked an item
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("The " + bookmark + " has been bookmarked");
					}
				}
				// Enable mark as kid-friendly only if it is eligible and that it's status is
				// unknown
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyDecision(bookmark);
						// if status is not unknown, we will save status
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							// pass to controller
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
						}
					}

					// Sharing feature for staff
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						//if true then share
						if(isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}

				}
			}
		}

	}
	
	//TODO: Below methods simulate user input, will implement actual user input via console
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;

	}

//	public static void bookmark(User user, Bookmark[][] bookmarkTable) {
//		System.out.println("\n" + user.getEmail() + " is bookmarking");
//		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
//			int bookmarkType = (int) (Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
//			int bookmarkNumber = (int) (Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
//			
//			Bookmark bookmark = bookmarkTable[bookmarkType][bookmarkNumber];
//			//View -> Controller
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//			
//			System.out.println(bookmark);
//		}
//	}

	private static String getKidFriendlyDecision(Bookmark bookmark) {
		// if < 0.4 approve, if no, >=0.4 && <= 0.8? y (rej) : n (unknown)
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() <= 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision() {
		// instead of just randomizing, the bookmark object can be passed in for further
		// filter logic
		return Math.random() < 0.5 ? true : false;
	}
}
