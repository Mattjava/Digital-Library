package com.example.Library.Manager.books.services.AuthorServices;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteAuthorService implements Command<Integer, String> {
    private AuthorRepository authorRepository;

    public DeleteAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public ResponseEntity<String> run(Integer id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            authorRepository.delete(author.get());
            return ResponseEntity.ok("Author successfully deleted");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
    }
}
