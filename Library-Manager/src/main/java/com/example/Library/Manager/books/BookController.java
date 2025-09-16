package com.example.Library.Manager.books;

import com.example.Library.Manager.books.models.*;
import com.example.Library.Manager.books.services.AuthorServices.AddAuthorService;
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

    private AddAuthorService addAuthorService;

    public BookController(GetAllBooksService getAllBooksService,
                          AddBookService addBookService,
                          DeleteBookService deleteBookService,
                          EditBookService editBookService,
                          GetAllAuthorsService getAllAuthorsService,
                          AddAuthorService addAuthorService) {

        this.getAllAuthorsService = getAllAuthorsService;
        this.addBookService = addBookService;
        this.deleteBookService = deleteBookService;
        this.editBookService = editBookService;
        this.getAllBooksService = getAllBooksService;
        this.addAuthorService = addAuthorService;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return getAllBooksService.run(null);
    }

    @GetMapping("author")
    public ResponseEntity<List<AuthorDTO>> getAllBooksFromAuthor() {
        return getAllAuthorsService.run(null);
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

    @DeleteMapping("books/{ibsn}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer ibsn)
    {
        return deleteBookService.run(ibsn);
    }

    @PutMapping("books/{ibsn}")
    public ResponseEntity<BookDTO> editBook(@PathVariable Integer ibsn, @RequestBody Book newBook)
    {
        EditBookPackage editBookPackage = new EditBookPackage(ibsn, newBook);
        return editBookService.run(editBookPackage);
    }
}
