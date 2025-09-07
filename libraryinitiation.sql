 create database library;

 use library;

 create table Book(
 	ISBN int not null auto_increment,
     Title varchar(255) default "Lorem Ipsum",
     Author varchar(255) default "John Doe",
     Publisher varchar(255) default "No Publisher",
     Genre varchar(255) default "None",
     PageLength int default 100,
     
     primary key (ISBN)
 );

 insert into Book(Title, Author, Publisher, Genre, PageLength) values
 	("Frankenstein", "Mary Shelly", "Simon & Schuster", "Horror", 250),
     ("Don Quixote", "Miguel de Cervantes", "", "Adventure", 500),
     ("Dictionary", "", "", "", 1000);
    
select * from Book where Author != "";
