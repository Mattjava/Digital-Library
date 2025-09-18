package com.example.Library.Manager.books;

import com.example.Library.Manager.books.models.*;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.models.dto.BookDTO;
import com.example.Library.Manager.books.models.packages.AddBookPackage;
import com.example.Library.Manager.books.models.packages.EditAuthorPackage;
import com.example.Library.Manager.books.models.packages.EditBookPackage;
import com.example.Library.Manager.books.services.AuthorServices.AddAuthorService;
import com.example.Library.Manager.books.services.AuthorServices.DeleteAuthorService;
import com.example.Library.Manager.books.services.AuthorServices.EditAuthorService;
import com.example.Library.Manager.books.services.AuthorServices.GetAllAuthorsService;
import com.example.Library.Manager.books.services.BookServices.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private GetAllBooksService getAllBooksService;
    private AddBookService addBookService;
    private DeleteBookService deleteBookService;
    private EditBookService editBookService;

    private GetAllAuthorsService getAllAuthorsService;
    private AddAuthorService addAuthorService;
    private EditAuthorService editAuthorService;
    private DeleteAuthorService deleteAuthorService;

    public BookController(GetAllBooksService getAllBooksService,
                          AddBookService addBookService,
                          DeleteBookService deleteBookService,
                          EditBookService editBookService,
                          GetAllAuthorsService getAllAuthorsService,
                          AddAuthorService addAuthorService,
                          EditAuthorService editAuthorService,
                          DeleteAuthorService deleteAuthorService) {
        this.getAllBooksService = getAllBooksService;
        this.addBookService = addBookService;
        this.deleteBookService = deleteBookService;
        this.editBookService = editBookService;
        this.getAllAuthorsService = getAllAuthorsService;
        this.addAuthorService = addAuthorService;
        this.editAuthorService = editAuthorService;
        this.deleteAuthorService = deleteAuthorService;
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
