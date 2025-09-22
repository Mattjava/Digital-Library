package com.example.Library.Manager.books.repositories;

import com.example.Library.Manager.books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("select author.name from Author author where author.country = :countryName")
    List<Author> findByCountry(@Param("countryName") String countryName);
}
