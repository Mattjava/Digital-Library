package com.example.Library.Manager.books.models.packages;

import com.example.Library.Manager.books.models.Book;

public class EditBookPackage {
    private Integer id;
    private Book book;

    public EditBookPackage(Integer id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
