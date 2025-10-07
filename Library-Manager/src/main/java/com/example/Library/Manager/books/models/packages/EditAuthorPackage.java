package com.example.Library.Manager.books.models.packages;

import com.example.Library.Manager.books.models.Author;

public class EditAuthorPackage {
    private Author author;
    private Integer id;

    public EditAuthorPackage(Author author, Integer id) {
        this.author = author;
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
