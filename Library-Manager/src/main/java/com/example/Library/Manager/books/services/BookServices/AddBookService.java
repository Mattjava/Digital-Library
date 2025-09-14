package com.example.Library.Manager.books.services.BookServices;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.models.AddBookPackage;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.BookDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import com.example.Library.Manager.books.repositories.BookRepository;
import com.example.Library.Manager.books.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddBookService implements Command<AddBookPackage, BookDTO> {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public AddBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public ResponseEntity<BookDTO> run(AddBookPackage input) {
        Book book = input.getBook();
        Author author = findValidAuthor(input.getAuthorId());

        book.setAuthor(author);

        bookRepository.save(book);

        return ResponseEntity.ok(new BookDTO(book));
    }

    public Author findValidAuthor(int authorId)
    {
        Optional<Author> result = authorRepository.findById(authorId);

        if(result.isPresent())
            return result.get();

        throw new RuntimeException("Author not found");
    }
}
