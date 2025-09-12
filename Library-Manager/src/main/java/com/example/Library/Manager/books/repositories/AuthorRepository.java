package com.example.Library.Manager.books.repositories;

import com.example.Library.Manager.books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
