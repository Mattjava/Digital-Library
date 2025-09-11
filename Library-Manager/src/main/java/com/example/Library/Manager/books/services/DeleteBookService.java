package com.example.Library.Manager.books.services;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.BookRepository;
import com.example.Library.Manager.books.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBookService implements Command<Integer, ResponseEntity<String>> {

    private BookRepository bookRepository;

    public DeleteBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<String> run(Integer input) {
        Optional<Book> issue = bookRepository.findById(input);

        if(issue.isPresent()) {
            bookRepository.deleteById(input);

            return ResponseEntity.ok(issue.get().getTitle() + " has been deleted");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found containing this ID");
    }
}
