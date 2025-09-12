package com.example.Library.Manager.books.services.BookServices;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.repositories.BookRepository;
import com.example.Library.Manager.books.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddBookService implements Command<Book, String> {
    private final BookRepository bookRepository;

    public AddBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public ResponseEntity<String> run(Book input) {
        bookRepository.save(input);

        return ResponseEntity.ok("Book has been created");
    }
}
