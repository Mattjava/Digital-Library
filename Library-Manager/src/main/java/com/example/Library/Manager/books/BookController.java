package com.example.Library.Manager.books;

import com.example.Library.Manager.books.models.*;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.models.dto.BookDTO;
import com.example.Library.Manager.books.models.packages.AddBookPackage;
import com.example.Library.Manager.books.models.packages.EditAuthorPackage;
import com.example.Library.Manager.books.models.packages.EditBookPackage;
import com.example.Library.Manager.books.services.AuthorServices.*;
import com.example.Library.Manager.books.services.BookServices.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private GetAllBooksService getAllBooksService;
    private GetBookService getBookService;
    private FindAllBooksByAuthorService findAllBooksByAuthorService;
    private FindAllBooksByCountryService findAllBooksByCountryService;
    private AddBookService addBookService;
    private DeleteBookService deleteBookService;
    private EditBookService editBookService;

    private GetAllAuthorsService getAllAuthorsService;
    private GetAuthorService getAuthorService;
    private FindAuthorsByCountry findAuthorsByCountry;
    private AddAuthorService addAuthorService;
    private EditAuthorService editAuthorService;
    private DeleteAuthorService deleteAuthorService;

    public BookController(AddAuthorService addAuthorService, AddBookService addBookService, DeleteAuthorService deleteAuthorService, DeleteBookService deleteBookService, EditAuthorService editAuthorService, EditBookService editBookService, FindAllBooksByAuthorService findAllBooksByAuthorService, FindAllBooksByCountryService findAllBooksByCountryService, FindAuthorsByCountry findAuthorsByCountry, GetAllAuthorsService getAllAuthorsService, GetAllBooksService getAllBooksService, GetAuthorService getAuthorService, GetBookService getBookService) {
        this.addAuthorService = addAuthorService;
        this.addBookService = addBookService;
        this.deleteAuthorService = deleteAuthorService;
        this.deleteBookService = deleteBookService;
        this.editAuthorService = editAuthorService;
        this.editBookService = editBookService;
        this.findAllBooksByAuthorService = findAllBooksByAuthorService;
        this.findAllBooksByCountryService = findAllBooksByCountryService;
        this.findAuthorsByCountry = findAuthorsByCountry;
        this.getAllAuthorsService = getAllAuthorsService;
        this.getAllBooksService = getAllBooksService;
        this.getAuthorService = getAuthorService;
        this.getBookService = getBookService;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return getAllBooksService.run(null);
    }

    @GetMapping("books/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Integer bookId) {
        return getBookService.run(bookId);
    }

    @GetMapping("author")
    public ResponseEntity<List<AuthorDTO>> getAllBooksFromAuthor() {
        return getAllAuthorsService.run(null);
    }

    @GetMapping("author/{authorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer authorId) {
        return getAuthorService.run(authorId);
    }

    @GetMapping("books/author/{authorId}")
    public ResponseEntity<List<BookDTO>> getAllBooksFromAuthorId(@PathVariable Integer authorId) {
        return findAllBooksByAuthorService.run(authorId);
    }

    @GetMapping("books/country/{countryName}")
    public ResponseEntity<List<BookDTO>> getAllBooksFromCountry(@PathVariable String countryName)
    {
        return findAllBooksByCountryService.run(countryName);
    }

    @GetMapping("author/country/{countryName}")
    public ResponseEntity<List<AuthorDTO>> getAllBooksFromAuthorCountry(@PathVariable String countryName) {
        return findAuthorsByCountry.run(countryName);
    }

    @PostMapping("books/{authorId}")
    public ResponseEntity<BookDTO> addBook(@RequestBody Book book, @PathVariable Integer authorId)
    {
        AddBookPackage pack = new AddBookPackage(book, authorId);
        return addBookService.run(pack);
    }

    @PostMapping("author")
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody Author author)
    {
        return addAuthorService.run(author);
    }

    @PutMapping("books/{ibsn}")
    public ResponseEntity<BookDTO> editBook(@PathVariable Integer ibsn, @RequestBody Book newBook)
    {
        EditBookPackage editBookPackage = new EditBookPackage(ibsn, newBook);
        return editBookService.run(editBookPackage);
    }

    @PutMapping("author/{id}")
    public ResponseEntity<AuthorDTO> editAuthor(@PathVariable Integer id, @RequestBody Author newAuthor)
    {
        EditAuthorPackage editAuthorPackage = new EditAuthorPackage(newAuthor, id);
        return editAuthorService.run(editAuthorPackage);
    }

    @DeleteMapping("books/{ibsn}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer ibsn)
    {
        return deleteBookService.run(ibsn);
    }

    @DeleteMapping("author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id)
    {
        return deleteAuthorService.run(id);
    }
}
