package com.anthonyang.livre.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.anthonyang.livre.managers.BookmarkManager;

/*
 * TDD 
 * 1. Add a test to fail(before creating function)
 * 2. Update enough code to pass test
 * 3. Refactor and repeat test
 */
class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: keyword "porn" in url -> false
		WebLink webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("'Porn' in url, isKidFriendlyEligible method must return false", isKidFriendlyEligible);

		// Test 2: keyword "porn" in title -> false
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming porn Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("'Porn' in title, isKidFriendlyEligible method must return false", isKidFriendlyEligible);

		// Test 3: keyword "adult" in host -> false
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("'adult' in host, isKidFriendlyEligible method must return false", isKidFriendlyEligible);

		// Test 4: keyword "adult" in url, but not in host -> true
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertTrue("'adult' in url but not host, isKidFriendlyEligible method must return true", isKidFriendlyEligible);

		// Test 5: keyword "adult" in title only -> true
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming adult Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertTrue("'adult' in title only, isKidFriendlyEligible method must return true", isKidFriendlyEligible);
	}

}
