package com.anthonyang.livre;

import com.anthonyang.livre.constants.BookGenre;
import com.anthonyang.livre.constants.Gender;
import com.anthonyang.livre.constants.MovieGenre;
import com.anthonyang.livre.constants.UserType;
import com.anthonyang.livre.entities.Bookmark;
import com.anthonyang.livre.entities.User;
import com.anthonyang.livre.entities.UserBookmark;
import com.anthonyang.livre.managers.BookmarkManager;
import com.anthonyang.livre.managers.UserManager;
import com.anthonyang.livre.util.IOUtil;

//Version one will use a datastore instead of a database.
public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;

	// 5 users
	private static User[] users = new User[TOTAL_USER_COUNT];
	public static User[] getUsers() {
		return users;
	}
	
	// 15 bookmarks, 5x weblinks, movies, books
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	// constraint -> 5 users x 5 bookmarks
	private static UserBookmark[] userBookmark = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex;
	
	public static void loadData() {
		loadUser();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUser() {
//		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "James", "M", Gender.MALE,	UserType.USER);
//		users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sheryl", "M", Gender.FEMALE,	UserType.USER);
//		users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Andy", "M", Gender.MALE,	UserType.EDITOR);
//		users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Ankita", "M", Gender.FEMALE,	UserType.EDITOR);
//		users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Xavier", "M", Gender.MALE,	UserType.CHIEF_EDITOR);
		
		String[] data = new String[TOTAL_USER_COUNT];
    	IOUtil.read(data, "User");
    	int rowNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		
    		int gender = Gender.MALE;
    		if (values[5].equals("f")) {
    			gender = Gender.FEMALE;
    		} else if (values[5].equals("t")) {
    			gender = Gender.TRANSGENDER;
    		}
    			
    		users[rowNum++] = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
    	}
		
	}
	
	private static void loadWebLinks() {
		//first dimension for WebLinks
//		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2001, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");
//		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2002, "Taming Tiger Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2003,	"NIO tutorial by Greg Travis", "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");
//		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html",	"http://tomcat.apache.org");
		
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "WebLink");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		bookmarks[0][colNum++] = BookmarkManager.getInstance().createWeblink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
    	}	
	}

	private static void loadMovies() {
		//Second dimension for Movies
//		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS,	8.5);
//		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940, new String[]{"Henry Fonda,Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS,	8.2);
//		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "Touch of Greatness", "", 2004, new String[]{"Albert Cullum"}, new String[]{"Leslie Sullivans"}, MovieGenre.DOCUMENTARIES,	7.3);
//		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", "", 2007, new String[]{"Kaley Cuoco", "Jim Parsons"}, new String[]{"Chuck Lorre", "Bill Prady"}, MovieGenre.TV_SHOWS, 8.7);
//		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", "", 1952, new String[]{"Takashi Shimura", "Minoru Chiaki"}, new String[]{"Akira Kurosawa"}, MovieGenre.FOREIGN_MOVIES,	8.4);

		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Movie");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] cast = values[3].split(",");
    		String[] directors = values[4].split(",");
    		bookmarks[1][colNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
    	}
	
	}

	private static void loadBooks() {
		//Third dimension for Books
//		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David"}, BookGenre.PHILOSOPHY, 4.3);
//		bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", 1988, "Dover Publications", new String[] {"Ralph Waldo Emerson"}, BookGenre.PHILOSOPHY, 4.5);
//		bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", 1854, "Touchstone", new String[] {"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
//		bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", 2004, "O'Reilly Media", new String[] {"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);
//		bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide", 2007, "Prentice Hall", new String[] {"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);

		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Book");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] authors = values[4].split(",");
    		bookmarks[2][colNum++] = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
    	}
 
	}

	public static void add(UserBookmark userBookmark2) {
		userBookmark[bookmarkIndex] = userBookmark2;
		bookmarkIndex++;
	}
}
