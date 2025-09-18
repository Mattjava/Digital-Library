package com.example.Library.Manager.books.models.dto;

import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.Book;

import java.util.Objects;

public class BookDTO {
    private int id;
    private String title;
    private Author author;
    private String publisher;
    private String genre;
    private int pageLength;

    public BookDTO(Book book) {
        this.id = book.getBookId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.genre = book.getGenre();
        this.pageLength = book.getPageLength();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return id == bookDTO.id && pageLength == bookDTO.pageLength && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author) && Objects.equals(publisher, bookDTO.publisher) && Objects.equals(genre, bookDTO.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publisher, genre, pageLength);
    }
}
