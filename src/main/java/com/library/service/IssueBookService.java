package com.library.service;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.entity.Student;
import com.library.repository.BookRepository;
import com.library.repository.IssueBookRepository;
import com.library.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssueBookService {

    private final IssueBookRepository issueBookRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public IssueBookService(
            IssueBookRepository issueBookRepository,
            BookRepository bookRepository,
            StudentRepository studentRepository) {

        this.issueBookRepository = issueBookRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    // Issue Book
    public IssueBook issueBook(int bookId, int studentId) {

        Book book = bookRepository
                .findById(bookId)
                .orElseThrow(() ->
                        new RuntimeException("Book not found"));

        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException(
                    "Book is not available");
        }

        IssueBook issueBook = new IssueBook();

        issueBook.setBook(book);
        issueBook.setStudent(student);
        issueBook.setIssueDate(LocalDate.now());
        issueBook.setStatus("ISSUED");

        book.setQuantity(
                book.getQuantity() - 1);

        bookRepository.save(book);

        return issueBookRepository.save(issueBook);
    }

    // Get All Issued Books
    public List<IssueBook> getAllIssues() {
        return issueBookRepository.findAll();
    }

    // Return Book
    public IssueBook returnBook(int issueId) {

        IssueBook issueBook =
                issueBookRepository.findById(issueId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Issue record not found"));

        if (issueBook.getStatus().equals("RETURNED")) {
            throw new RuntimeException(
                    "Book already returned");
        }

        issueBook.setStatus("RETURNED");
        issueBook.setReturnDate(LocalDate.now());

        Book book = issueBook.getBook();

        book.setQuantity(
                book.getQuantity() + 1);

        bookRepository.save(book);

        return issueBookRepository.save(issueBook);
    }





}
