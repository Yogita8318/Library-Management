package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>{

    public List<Book> findByTitleContainingIgnoreCase(String title);
    public List<Book> findByQuantityGreaterThan(int quantity);

}
