# LibraryDB

## Introduction

## Setup

## Methodology

## USER STORIES
- As a library patron, I want to find nonfiction books by genre/topic so that I can do research.
- As a library patron, I want to find fiction books by author/title so that I can find my favorite books to read.
- As a library patron, I want to find fiction books by genre so that I can find similar books to read.
- As a library manager, I want to enter new books so that the library can grow.
- As a library manager, I want to delete books that the library no longer holds.
- As a library manager, I want to determine which books are checked out so I can determine if others can access them. 
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
Here is the diagram we built of our models using [Lucid Charts](https://lucid.app/lucidchart/8f452d56-9d67-45b3-af99-39b1321dd559/edit?invitationId=inv_197ee268-2fe8-4f5e-8fc1-d4f8e0cc5f9c).

