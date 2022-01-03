# Personal Library App

## Project Description
We are creating a personal library application that an individual or family can utilize to keep track of their print media (both physical and digital). Users of the library application will be able to search/view the books they already own, add new ones, or delete ones they no longer possess. By using the library application, people will be able to efficiently keep track of their books!

## Setup

## Methodology

## USER STORIES
- As a library patron, I want to find nonfiction books by genre/topic so that I can do research.
- As a library patron, I want to find fiction books by author/title so that I can find my favorite books to read.
- As a library patron, I want to find fiction books by genre so that I can find similar books to read.
- As a library patron, I want to be able to determine the media type so I know where to look for the book.
- As a library patron, I want to search for books that I own but haven't read yet. 
- As a library manager, I want to enter new books so that the library can grow.
- As a library manager, I want to delete books that the library no longer holds.
- As a library manager, I want to determine which books are checked out so I can determine if others can access them. 
- As a library manager, I want to be able to search by genre to create reading lists. 
- As a library manager, I want to enter new authors so that the we can track new book writers.
- As a library manager, I want to update information so that the we can keep records current.

## END POINTS
|Method |Endpoints                           |Description                   |
|-------|------------------------------------|------------------------------|
|GET    |api/books                           |returns JSON of all books     |
|POST   |api/books                           |reates new book               |
|GET    |api/books/{bookID}                  |returns JSON for book         |
|PUT    |api/books/{bookID}                  |updates specific book         |
|DELETE	|api/books/{bookID}                  |deletes specific book         |
|       |                                    |                              |
|GET	|api/authors        	             |returns JSON of all authors   |
|POST	|api/authors			             |creates new author            |
|GET    |api/authors/{authorID}	             |returns JSON for author       |
|PUT    |api/authors/{authorID}              |updates specific author       |
|DELETE	|api/authors/{authorID}              |deletes specific author       |
|       |                                    |                              |  
|GET    |api/publishers                      |returns JSON of all publishers|
|POST	|api/publishers				         |creates new publisher         |
|GET    |api/publishers/{publisherID}        |returns JSON for publisher    |
|PUT    |api/publishers/{publisherID}        |updates specific publisher    |
|DELETE	|api/publishers/{publisherID}        |deletes specific publisher    |
|       |                                    |                              |
|GET	|api/genres							 |returns a list of Fic genres  |
|POST	|api/genres							 |creates new genre             |
|PUT    |api/genres/{genreID}				 |updates                       |
|DELETE |api/genres/{genreID}				 |deletes                       |
|GET    |api/genres/{genreID}/books			 |returns JSON of books in genre|
|       |                                    |                              |
|GET	|api/authors/{authorID}/books        |returns JSON of author's books|
|GET    |api/books/{bookID}/author	         |returns JSON of book's authors|
|GET	|api/publishers/{publisherID}/books  |	returns JSON of pub's books |
|GET	|api/publishers/{publisherID}/authors|returns JSON of pub's authors |

## ERD Diagram
Here is the diagram we built of our models.
![ERD Diagram](https://user-images.githubusercontent.com/79819338/147974942-de8f0ac4-6df4-4e1c-87d7-d171c61c1e08.png)


