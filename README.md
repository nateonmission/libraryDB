# Personal Library App

## PROJECT DESCRIPTION

We are creating a personal library application that an individual or family can utilize to keep track of their print
media (both physical and digital). Users of the library application will be able to search/view the books they already
own, add new ones, or delete ones they no longer possess. By using the library application, people will be able to
efficiently keep track of their books!

## END POINTS

| Method |Endpoints                           | Description                    | Done   |
|--------|------------------------------------|--------------------------------|--------|
| GET    |api/books                           | returns all books              | Tested |
| POST   |api/books                           | creates new book               | Tested |
| GET    |api/books/{bookID}                  | returns a book                 | Tested |
| PUT    |api/books/{bookID}                  | updates specific book          | Tested |
| DELETE |api/books/{bookID}                  | deletes specific book          | Tested |
|        |                                    |                                |        |
| GET    |api/authors                         | returns all authors            | Tested |
| POST   |api/authors                         | creates new author             | Tested |
| GET    |api/authors/{authorID}              | returns JSON for author        | Tested |
| PUT    |api/authors/{authorID}              | updates specific author        | Tested |
| DELETE |api/authors/{authorID}              | deletes specific author        | Tested |
|        |                                    |                                |        |  
| GET    |api/publishers                      | returns all publishers         | Tested |
| POST   |api/publishers                      | creates new publisher          | Tested |
| GET    |api/publishers/{publisherID}        | get single publisher           | Tested |
| PUT    |api/publishers/{publisherID}        | updates specific publisher     | Tested |
| DELETE |api/publishers/{publisherID}        | deletes specific publisher     | Tested |
|        |                                    |                                |        |
| GET    |api/genres                          | returns a list of genres       | Tested |
| POST   |api/genres                          | creates new genre              | Tested |
| GET    |api/genres/{genreID}                | get single genre               | Tested |
| PUT    |api/genres/{genreID}                | updates                        | Tested |
| DELETE |api/genres/{genreID}                | deletes                        | Tested |
|        |                                    |                                |        |
| GET    |api/genres/{genreID}/books          | returns JSON of books in genre |        |
| GET    |api/authors/{authorID}/books        | returns JSON of author's books |        |
| GET    |api/books/{bookID}/author           | returns JSON of book's authors | X      |
| GET    |api/publishers/{publisherID}/books  | returns JSON of pub's books    |        |
| GET    |api/publishers/{publisherID}/authors| returns JSON of pub's authors  | X      |

## PLANNING

### ERD Diagram
Here is the diagram we built of our models.
![ERD Diagram](https://user-images.githubusercontent.com/79819338/148406873-2b707cb8-9c64-4029-a1c6-ea8f6001adac.png)

### User Stories

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

### Timeline
Day 1: Preparation/planning, setup Spring Boot files; Create book, author, genre, and publisher models <br>
Day 2: Create book, author, genre, and publisher repositories; Create exceptions; Create book service and book controller <br>
Day 3: Debug Many to Many connections <br>
Day 4: Debug Endpoints <br>
Day 5: Bonus items <br>
Day 6: Polishing up and presentation

### MVP
Our minimum viable product (MVP) will be a database that persists four models--book, author, genre, and publisher. Each will have the full CRUD endpoints created using REST conventions. If an invalid request is made, the user will be notified via an error statement.

### Bonus Items
- Create a User (model, repository, service, controller)
- Handle security with JWT
- Create unit and integration tests

### Challenges/Hurdles
Our biggest challenge was utilizing Many To Many mapping for the relationships between our models. Since we had not encountered during classtime an example of how this would be implemented, it required us to do quite a bit of research, trial/error, more research, then assistance from more experienced brains! But in the end, it was a good learning experience that will likely be useful in future applications. 

## TECHNOLOGY USED
1. Lucid Charts to create the ERD.
2. Java in IntelliJ IDEA
3. Spring Boot
4. Maven
5. PostgreSQL and pgAdmin for database/tables
6. Postman to test Endpoints

## INSTALLATION INSTRUCTIONS
1. Fork and clone the repository.
2. Using pgAdmin, create a database called ```librarydb```.
3. Open the file ```libraryDB/src/main/resources/application-dev.properties``` and ensure line 1 states that port 9092 is going to be used. Change lines 6 and 7 to your PostgreSQL username and password. 
4. 


