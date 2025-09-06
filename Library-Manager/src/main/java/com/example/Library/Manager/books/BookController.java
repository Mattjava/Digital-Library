package com.example.Library.Manager.books;

import com.example.Library.Manager.books.services.GetBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private GetBookService getBookService;

    public BookController() {
        this.getBookService = GetBookService();
    }
}
