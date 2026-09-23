📚 Library Management System

A **Library Management System** developed using **Java, Spring Boot, Spring Data JPA, Hibernate and MySQL**.

This project provides REST APIs to manage books, students, book issuing and book returning operations in a library.

---
## 🚀 Features

### 📖 Book Management
- Add a new book
- View all books
- View book by ID
- Update book details
- Delete a book
- Delete all books
- Search books by title
- View available books

### 👨‍🎓 Student Management
- Add a new student
- View all students
- View student by ID
- Update student details
- Delete a student
- Delete all students
- Search students by name

### 📚 Issue Book
- Issue a book to a student
- Automatically decrease available book quantity
- Store issue date
- Maintain issue status

### 🔄 Return Book
- Return an issued book
- Automatically increase available book quantity
- Store return date
- Change status from `ISSUED` to `RETURNED`

### 🛡️ Exception Handling
- Resource not found handling
- Book availability validation
- Already returned book validation
- Global exception handling using `@RestControllerAdvice`

---

# 🛠️ Technologies Used

| Technology | Version / Usage |
|---|---|
| Java | 17 |
| Spring Boot | 4.1.1 |
| Spring Web | REST APIs |
| Spring Data JPA | Database operations |
| Hibernate | ORM |
| MySQL | Database |
| Maven | Dependency Management |
| IntelliJ IDEA | Development IDE |
| Postman | API Testing |
| Git & GitHub | Version Control |

---
# 🏗️ Project Architecture

The project follows a layered architecture:

```text
Client / Postman
       ↓
   Controller
       ↓
     Service
       ↓
   Repository
       ↓
     Entity
       ↓
     MySQL

Controller Layer

Handles HTTP requests and API endpoints.

Service Layer

Contains business logic.

Repository Layer

Communicates with the database using Spring Data JPA.

Entity Layer

Represents database tables.

Exception Layer

Handles application exceptions globally.

📁 Project Structure

LibraryManagement
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.library
│   │   │
│   │   │       ├── controller
│   │   │       │   ├── BookController.java
│   │   │       │   ├── StudentController.java
│   │   │       │   └── IssueBookController.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   ├── BookService.java
│   │   │       │   ├── StudentService.java
│   │   │       │   └── IssueBookService.java
│   │   │       │
│   │   │       ├── repository
│   │   │       │   ├── BookRepository.java
│   │   │       │   ├── StudentRepository.java
│   │   │       │   └── IssueBookRepository.java
│   │   │       │
│   │   │       ├── entity
│   │   │       │   ├── Book.java
│   │   │       │   ├── Student.java
│   │   │       │   └── IssueBook.java
│   │   │       │
│   │   │       ├── exception
│   │   │       │   ├── ResourceNotFoundException.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       └── LibraryManagementApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md

🗄️ Database

The project uses MySQL.

Database Name
librarydb

Create the database using:

CREATE DATABASE librarydb;

📊 Database Tables

The application automatically creates/updates tables using Hibernate.

1. Books Table
books
Column	          Description
id	              Book ID
title	          Book title
author	          Book author
category	      Book category
quantity	      Total quantity

2. Students Table
students
Column	          Description
id	              Student ID
name	          Student name
email	          Student email
phone	          Student phone
city	          Student city

3. Issue Books Table
issue_books
Column	           Description
id	               Issue ID
book_id	           Book reference
student_id	       Student reference
issue_date	       Book issue date
return_date        Book return date
status	           ISSUED / RETURNED


