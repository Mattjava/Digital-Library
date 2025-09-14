package com.example.Library.Manager.books.models;

public class AddBookPackage {
    private Book book;
    private Integer authorId;

    public AddBookPackage(Book book, Integer authorId)
    {
        this.book = book;
        this.authorId = authorId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
