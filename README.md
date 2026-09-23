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

