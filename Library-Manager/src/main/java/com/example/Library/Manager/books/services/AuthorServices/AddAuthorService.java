package com.example.Library.Manager.books.services.AuthorServices;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddAuthorService implements Command<Author, AuthorDTO> {
    private AuthorRepository authorRepository;

    public AddAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<AuthorDTO> run(Author input) {
        authorRepository.save(input);

        return ResponseEntity.ok(new AuthorDTO(input));
    }
}
