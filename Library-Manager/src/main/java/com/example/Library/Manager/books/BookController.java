package com.example.Library.Manager.books;

import com.example.Library.Manager.books.models.AuthorDTO;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.BookDTO;
import com.example.Library.Manager.books.models.EditBookPackage;
import com.example.Library.Manager.books.services.AuthorServices.GetAllAuthorsService;
import com.example.Library.Manager.books.services.BookServices.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private GetAllBooksService getAllBooksService;
    private GetAllAuthorsService getAllAuthorsService;
    private AddBookService addBookService;
    private DeleteBookService deleteBookService;
    private EditBookService editBookService;

    public BookController(GetAllBooksService getAllBooksService,
                          AddBookService addBookService,
                          DeleteBookService deleteBookService,
                          EditBookService editBookService,
                          GetAllAuthorsService getAllAuthorsService) {

        this.getAllAuthorsService = getAllAuthorsService;
        this.addBookService = addBookService;
        this.deleteBookService = deleteBookService;
        this.editBookService = editBookService;
        this.getAllBooksService = getAllBooksService;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return getAllBooksService.run(null);
    }

    @GetMapping("author")
    public ResponseEntity<List<AuthorDTO>> getAllBooksFromAuthor() {
        return getAllAuthorsService.run(null);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book)
    {
        return addBookService.run(book);
    }

    @DeleteMapping("/{ibsn}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer ibsn)
    {
        return deleteBookService.run(ibsn);
    }

    @PutMapping("/{ibsn}")
    public ResponseEntity<String> editBook(@PathVariable Integer ibsn, @RequestBody Book newBook)
    {
        EditBookPackage editBookPackage = new EditBookPackage(ibsn, newBook);
        return editBookService.run(editBookPackage);
    }
}
