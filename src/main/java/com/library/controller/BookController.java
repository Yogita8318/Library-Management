package com.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // READ ALL
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // READ ONE
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // UPDATE
    @PutMapping("/books/{id}")
    public Book updateBook(
            @PathVariable int id,
            @RequestBody Book book) {

        return bookService.updateBook(id, book);
    }

    // DELETE
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

}
