package com.example.Library.Manager.books.services.BookServices;

import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.dto.BookDTO;
import com.example.Library.Manager.books.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetBookService implements Query<Integer, BookDTO> {
    private BookRepository bookRepository;

    public GetBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public ResponseEntity<BookDTO> run(Integer input) {
        Optional<Book> book = bookRepository.findById(input);

        if (book.isPresent()) {
            return ResponseEntity.ok(new BookDTO(book.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
