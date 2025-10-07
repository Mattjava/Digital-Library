# Digital-Library
A Spring-Boot Library to store and manage books, authors, and many more.

# How does it work?

Digit Library is a Java-powered library application. It utilizies Spring Boot to create a library manager API. This API is able to communicate with a library database to gather book and author data. This will allow libraries, and tech-savvy bookworms, to save data about their books and authors

# Why did you make this?

A big factor into making this is my love for books. I've read many books in the past, and I've even volunteered at a library during high school. This project is based off of those experiences and some of the issues I've encountered in the past. I'm also inspired by many applications catered to book-lovers like me, like GoodReads. In short, this project serves as a love-letter to libraries. 

# How do I run it?

To begin with, you must be able to run a book database. I use MySQL's community server to run this application; therefore, that is my suggested database for this project. However, you're free to use whatever you want. Just make sure you edit the app's configurations to bind the Spring app to it.

Once you've set up your database, you must run libraryinitiation.sql. This will create the schemas necessary for the API to work. Be sure to review the comments in that file for more instructions on how to run it. 

Finally, run the Spring Boot application in LibraryManagerApplication.java. This will officially start up the API.

# The Future.

I plan to implement many details into this project. This includes advanced SQL queries that will upgrade the API's capabilities. I also might add a frontend interface for the API. This will make the app more accessible for the user.