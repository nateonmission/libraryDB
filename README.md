# LibraryDB

## USER STORIES
- As a library parton, I want to find NF books by topic so that I can do research.
- As a library parton, I want to find Fic books by genre so that I can find my favorite books to read.
- As a library manager, I want to enter new books so that the libreary can grow.
- As a library manager, I want to enter new authors so that the we can track new book writers.
- As a library manager, I want to update information so that the we can keep records current.

## END POINTS

GET				api/books							returns JSON of all books
POST			api/books							reates new book
GET     		api/books/{bookID}					returns JSON for book
PUT     		api/books/{bookID}					updates specific book
DELETE			api/books/{bookID}					deletes specific book

GET				api/authors							returns JSON of all authors
POST			api/authors							creates new author
GET     		api/authors/{authorID}				returns JSON for author
PUT     		api/authors/{authorID}				updates specific author
DELETE			api/authors/{authorID}				deletes specific author

GET				api/publishers						returns JSON of all publishers
POST			api/publishers						creates new publisher
GET     		api/publishers/{publisherID}		returns JSON for publisher
PUT     		api/publishers/{publisherID}		updates specific publisher
DELETE			api/publishers/{publisherID}		deletes specific publisher

GET				api/authors/{authorID}/books		returns JSON of author's books
GET				api/books/{bookID}/author			returns JSON of book's authors
GET				api/publishers/{publisherID}/books	returns JSON of pub's books
GET				api/publishers/{publisherID}/authorsreturns JSON of pub's authors

GET				api/topics							returns a list of NF topics
POST			api/topics							creates new topic
PUT             api/topics/{topicID}				updates
DELETE          api/topics/{topicID}				deletes
GET				api/topics/{topicID}/books			returns JSON of books in topic

GET				api/genres							returns a list of Fic genres
POST			api/genres							creates new genre
PUT             api/genres/{genreID}				updates
DELETE          api/genres/{genreID}				deletes
GET				api/genres/{genreID}/books			returns JSON of books in genre


