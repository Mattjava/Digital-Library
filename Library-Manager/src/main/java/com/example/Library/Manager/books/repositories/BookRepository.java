package com.example.Library.Manager.books.repositories;

import com.example.Library.Manager.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.author = ?1")
    public List<Book> findAllByAuthor(String author);
}
