package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
