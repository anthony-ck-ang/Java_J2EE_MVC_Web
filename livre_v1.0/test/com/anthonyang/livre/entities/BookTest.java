package com.anthonyang.livre.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.anthonyang.livre.constants.BookGenre;
import com.anthonyang.livre.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: BookGenre is "Philosophy" -> false
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David" }, BookGenre.PHILOSOPHY, 4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("Philosophy genre book, result should return false", isKidFriendlyEligible);

		// Test 2: BookGenre is "Self-help" -> false
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David" }, BookGenre.SELF_HELP, 4.3);
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("Self-help genre book, result should return false", isKidFriendlyEligible);
	}
}
