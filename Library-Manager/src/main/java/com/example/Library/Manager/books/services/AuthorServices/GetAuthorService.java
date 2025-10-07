package com.example.Library.Manager.books.services.AuthorServices;

import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAuthorService implements Query<Integer, AuthorDTO> {
    private AuthorRepository authorRepository;

    public GetAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<AuthorDTO> run(Integer input) {
        Optional<Author> author = authorRepository.findById(input);

        if (author.isPresent()) {
            AuthorDTO authorDTO = new AuthorDTO(author.get());
            return ResponseEntity.ok(authorDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
