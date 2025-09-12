
-- VV Run if database isn't created VV
-- create database library;

-- VV Uncomment this if you want to reset the tables VV
-- drop table book;
-- drop table author;


use library;

create table author(
	id int not null auto_increment,
    name varchar(255) default "John Doe",
    city varchar(255) default "No City",
    country varchar(255) default "No Country",
    website varchar(255) default "https://example.com",
    
    primary key(id)
);

create table Book(
 	isbn int not null auto_increment,
     title varchar(255) default "Lorem Ipsum",
     author int,
     publisher varchar(255) default "No Publisher",
     genre varchar(255) default "None",
     page_length int default 100,
     
     primary key (isbn),
	 foreign key (author) references author(id)
 );

insert into author(name, city, country, website) values
	("Mary Shelley", "London", "United Kingdom", " "),
    ("Miguel de Cervantes", "Madrid", "Spain", "https://en.wikipedia.org/wiki/Miguel_de_Cervantes"),
    ("John Doe", "New York City", "United States", "");

insert into Book(title, author, publisher, genre, page_length) values
 	("Frankenstein", 1, "Simon & Schuster", "Horror", 250),
     ("Don Quixote", 2, "", "Adventure", 500),
     ("Dictionary", 3, "", "", 1000);
    
select book.title, author.name, book.publisher, book.page_length from book right join author on book.author = author.id;