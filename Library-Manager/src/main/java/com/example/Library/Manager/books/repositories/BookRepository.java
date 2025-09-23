package com.example.Library.Manager.books.repositories;

import com.example.Library.Manager.books.models.Author;
import com.example.Library.Manager.books.models.Book;
import com.example.Library.Manager.books.models.dto.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findByAuthor(@Param("author") Author author);
}
