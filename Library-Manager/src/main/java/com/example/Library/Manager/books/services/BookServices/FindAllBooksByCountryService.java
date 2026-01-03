package com.example.Library.Manager.books.services.BookServices;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.dto.BookDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import com.example.Library.Manager.books.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FindAllBooksByCountryService implements Command {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public FindAllBooksByCountryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private String filter(String input) {
        String[] parts = input.split("_");

        String country = "";

        for(int i = 0; i < parts.length - 1; i++)
            country += parts[i] + " ";

        country += parts[parts.length - 1];

        return country;
    }

    @Override
    public ResponseEntity<List<BookDTO>> run(Object input) {
        String country = filter((String) input);

        List<Author> authorList = authorRepository.findByCountry(country);

        List<BookDTO> result = new LinkedList<>();

        for(Author author : authorList)
        {
            List<Book> bookList = bookRepository.findByAuthor(author);

            result.addAll(bookList.stream().map(BookDTO::new).toList());
        }

        return ResponseEntity.ok(result);
    }
}
