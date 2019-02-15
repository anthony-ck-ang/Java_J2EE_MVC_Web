# ABC Bank Web MVC mock Demo

Web mock banking demo that does CRUD operations.

# Livre Bookmarking Application v1.0
Project Specification
1. Load Data (DataStore)
  - 5 users
  - 15 bookmarks
    - 5 weblinks
    - 5 movies
    - 5 books
    
2. User Bookmarking Feature
Requirement: To allow each user to bookmark 5 items; duplicates are allowed.

3. Mark KidFriendly Bookmark Feature
Requirement: To allow only editors or chief editor to approve or reject a bookmark's kid friendly eligibility.

4. Share Kid friendly bookmarks Feature.
Requirement: To allow Kid friendly bookmarks to be shared to other partners.

UserTypes
1. Regular end users
  I.
  - can save weblinks, movies, books
  - rate bookmarks
  - post review (subject to approval)
2. Staff
  - Email admin  
    - have access to all features in I. 
    - post review without the need for approval
    - handle email campaign
  - Editor
    - have access to all features in I. and
    - II.
      - post review
      - approve review
      - reject review
  - Chief editor
    - have access to all features in I. 
    - have access to all features in II. and
    - update homepage
    
# livre Bookmarking Application v1.1
Features implemented:
- Read user and bookmark data from text file (read from file)
- Download weblinks/webpage (read from remote host) and write to disk

Benefit: 
- maintain a local cache of the webpage. 
- webpage content can still be browsed by user even if the host is unavailable.

Webpages can be index which enable users to search for specific content amongst the webpages.
search feature, index is a datastructure which enbles efficient text search.
third party libraries such as Lucine which helpes with indexing of documents.
Index feature is unavailable in this version.
