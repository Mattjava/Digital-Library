package com.example.Library.Manager.books.services.AuthorServices;

import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.AuthorDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAuthorsService implements Query<Void, List<AuthorDTO>> {
    private AuthorRepository authorRepository;


    public GetAllAuthorsService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<List<AuthorDTO>> run(Void input) {
        List<Author> authors = authorRepository.findAll();

        List<AuthorDTO> authorList = authors.stream().map(AuthorDTO::new).toList();

        return ResponseEntity.ok(authorList);
    }
}
