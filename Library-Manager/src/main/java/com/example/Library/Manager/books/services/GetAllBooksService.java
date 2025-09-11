package com.example.Library.Manager.books.services;

import com.example.Library.Manager.books.BookRepository;
import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllBooksService implements Query<Void, List<BookDTO>> {

    private final BookRepository bookRepository;

    public GetAllBooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<List<BookDTO>> run(Void input) {
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = bookList.stream().map(BookDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOList);
    }
}
