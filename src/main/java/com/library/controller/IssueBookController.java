package com.library.controller;

import com.library.entity.IssueBook;
import com.library.repository.IssueBookRepository;
import com.library.service.IssueBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueBookController {

   private final IssueBookService issueBookService;

   public IssueBookController(
           IssueBookService issueBookService) {

      this.issueBookService = issueBookService;
   }

   // Issue Book
   @PostMapping("/issue")
   public IssueBook issueBook(
           @RequestParam int bookId,
           @RequestParam int studentId) {

      return issueBookService.issueBook(
              bookId, studentId);
   }

   // All Issued Books
   @GetMapping("/issue/all")
   public List<IssueBook> getAllIssues() {
      return issueBookService.getAllIssues();
   }

   // Return Book
   @PutMapping("/{id}/return")
   public IssueBook returnBook(
           @PathVariable int id) {

      return issueBookService.returnBook(id);
   }




}
