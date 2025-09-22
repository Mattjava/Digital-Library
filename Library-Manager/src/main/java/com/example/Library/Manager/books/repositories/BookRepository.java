package com.example.Library.Manager.books.repositories;

import com.example.Library.Manager.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.author = :authorId")
    List<Book> findByAuthor(@Param("authorId") Integer authorId);
}
