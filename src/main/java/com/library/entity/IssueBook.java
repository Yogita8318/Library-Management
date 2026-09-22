package com.library.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="issue_books")
public class IssueBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    private LocalDate issueDate;
    private LocalDate returnDate;
    private String status;
    //default constructor
    public IssueBook() {
        super();
    }
    //parameterized constructor

    public IssueBook(Integer id, Book book, Student student, LocalDate issueDate, LocalDate returnDate, String status) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    //setter and getter method
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
