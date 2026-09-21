package com.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {
	
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Save book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by id
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Update book
    public Book updateBook(int id, Book book) {

        Book oldBook = bookRepository.findById(id).orElse(null);

        if (oldBook != null) {

            oldBook.setTitle(book.getTitle());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setCategory(book.getCategory());
            oldBook.setPrice(book.getPrice());

            return bookRepository.save(oldBook);
        }

        return null;
    }

    // Delete book
    public String deleteBook(int id) {

        if (bookRepository.existsById(id)) {

            bookRepository.deleteById(id);

            return "Book deleted successfully";
        }

        return "Book not found";
    }
	

}
