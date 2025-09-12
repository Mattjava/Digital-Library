package com.example.Library.Manager.books.services.BookServices;

import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.repositories.BookRepository;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.EditBookPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditBookService implements Query<EditBookPackage, String> {
    private BookRepository bookRepository;

    public EditBookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<String> run(EditBookPackage input) {
        Optional<Book> oldBook = bookRepository.findById(input.getId());

        if(oldBook.isPresent()) {
            Book newBook = input.getBook();
            newBook.setBookId(input.getId());
            bookRepository.save(newBook);

            return ResponseEntity.ok(newBook.getTitle() + " has been changed");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found. Please create one");
    }
}
