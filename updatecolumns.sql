-- Run before starting Spring Boot.

alter table book rename column ISBN to isbn; 
alter table book rename column Title to title;
alter table book rename column Author to author;
alter table book rename column Publisher to publisher;
alter table book rename column Genre to genre;
alter table book rename column PageLength to page_length;