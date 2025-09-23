package com.example.Library.Manager.books.services.AuthorServices;

import com.example.Library.Manager.Query;
import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import com.example.Library.Manager.books.repositories.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindAuthorsByCountry implements Query<String, List<AuthorDTO>> {
    private AuthorRepository authorRepository;

    public FindAuthorsByCountry(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<List<AuthorDTO>> run(String input) {
        input = filter(input);

        List<Author> authorList = authorRepository.findByCountry(input);

        List<AuthorDTO> authorDTOList = authorList.stream().map(AuthorDTO::new).toList();

        return ResponseEntity.ok(authorDTOList);
    }

    private String filter(String input) {
        String[] parts = input.split("_");

        String country = "";

        for(int i = 0; i < parts.length - 1; i++)
            country += parts[i] + " ";

        country += parts[parts.length - 1];

        return country;
    }
}
