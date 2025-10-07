package com.example.Library.Manager.books.services.BookServices;

import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.models.dto.BookDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import com.example.Library.Manager.books.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FindAllBooksByAuthorService implements Query<Integer, List<BookDTO>> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public FindAllBooksByAuthorService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<List<BookDTO>> run(Integer input) {
        Optional<Author> author = authorRepository.findById(input);

        if (author.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


        List<Book> bookList = bookRepository.findByAuthor(author.get());

        List<BookDTO> bookDTOList = bookList.stream().map(BookDTO::new).toList();

        return ResponseEntity.ok(bookDTOList);
    }
}
