package com.example.Library.Manager.books;

import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.BookDTO;
import com.example.Library.Manager.books.models.EditBookPackage;
import com.example.Library.Manager.books.services.AddBookService;
import com.example.Library.Manager.books.services.DeleteBookService;
import com.example.Library.Manager.books.services.EditBookService;
import com.example.Library.Manager.books.services.GetAllBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private GetAllBooksService getAllBooksService;
    private AddBookService addBookService;
    private DeleteBookService deleteBookService;
    private EditBookService editBookService;

    public BookController(GetAllBooksService getAllBooksService,
                          AddBookService addBookService,
                          DeleteBookService deleteBookService,
                          EditBookService editBookService) {

        this.getAllBooksService = getAllBooksService;
        this.addBookService = addBookService;
        this.deleteBookService = deleteBookService;
        this.editBookService = editBookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return getAllBooksService.run(null);
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
