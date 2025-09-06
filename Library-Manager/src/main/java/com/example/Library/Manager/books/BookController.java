package com.example.Library.Manager.books;

import com.example.Library.Manager.books.models.BookDTO;
import com.example.Library.Manager.books.services.GetAllBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private GetAllBooksService getAllBooksService;

    public BookController(GetAllBooksService getAllBooksService) {
        this.getAllBooksService = getAllBooksService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return getAllBooksService.run(null);
    }
}
