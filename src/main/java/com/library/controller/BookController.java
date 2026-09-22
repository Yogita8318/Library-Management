package com.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE a book(add a book)
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // READ ALL
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // READ ONE book by id
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // UPDATE by id
    @PutMapping("/books/{id}")
    public Book updateBook(
            @PathVariable int id,
            @RequestBody Book book) {

        return bookService.updateBook(id, book);
    }

    // DELETE by id
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
    //Search a book
    @GetMapping("/search/title")
    public List<Book> searchBook(@RequestParam String title)
    {
        return bookService.searchBook(title);
    }
    //Available book
    @GetMapping("/available")
    public List<Book> getAvailableBook()
    {
        return bookService.getAvailableBooks();
    }

}
