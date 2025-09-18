package com.example.Library.Manager.books.services.AuthorServices;

import com.example.Library.Manager.Command;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.models.packages.EditAuthorPackage;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditAuthorService implements Command<EditAuthorPackage, AuthorDTO> {
    private AuthorRepository authorRepository;

    public EditAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public ResponseEntity<AuthorDTO> run(EditAuthorPackage input) {
        Optional<Author> oldAuthor = authorRepository.findById(input.getId());

        if (oldAuthor.isPresent()) {
            Author newAuthor = oldAuthor.get();
            newAuthor.setId(oldAuthor.get().getId());
            authorRepository.save(newAuthor);

            return ResponseEntity.ok(new AuthorDTO(newAuthor));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
