package com.anthonyang.livre.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.anthonyang.livre.constants.MovieGenre;
import com.anthonyang.livre.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: MovieGenre is "Thriller" -> false
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("Thriller genre, result should return false", isKidFriendlyEligible);

		// Test 2: MovieGenre is "Horror" -> false
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("Thriller genre, result should return false", isKidFriendlyEligible);
	}

}
