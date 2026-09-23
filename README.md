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

-----------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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
----------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
2. Students Table
students
Column	          Description
id	              Student ID
name	          Student name
email	          Student email
phone	          Student phone
city	          Student city
----------------------------------------------------------------------------------------------------------
3. Issue Books Table
issue_books
Column	           Description
id	               Issue ID
book_id	           Book reference
student_id	       Student reference
issue_date	       Book issue date
return_date        Book return date
status	           ISSUED / RETURNED
----------------------------------------------------------------------------------------------------------
🔗 Entity Relationships

The project uses JPA relationships to connect books, students, and issue records.

Book
  │
  │ 1
  │
  │ *
  ▼
IssueBook
  ▲
  │ *
  │
  │ 1
Student

Relationships:

Book    1 ──────── * IssueBook
Student 1 ──────── * IssueBook

An IssueBook record contains references to both the associated Book and Student.
---------------------------------------------------------------------------------------------------------------
🔌 REST API Documentation

Base URL:

http://localhost:8080
---------------------------------------------------------------------------------------------------------------
📖 Book APIs
Add Book
POST /books

Request Body:

{
    "title": "Godan",
    "author": "Munshi Premchand",
    "category": "Hindi",
    "quantity": 10,
    "availableQuantity": 10
}
--------------------------------------------------------------------------------------------------------------
Get All Books
GET /books
--------------------------------------------------------------------------------------------------------------
Get Book by ID
GET /books/{id}

Example:

GET /books/1
-------------------------------------------------------------------------------------------------------------
Update Book
PUT /books/{id}

Example:

PUT /books/1

Request Body:

{
    "title": "Nirmala",
    "author": "Munshi Premchand",
    "category": "Hindi",
    "quantity": 15,
    "availableQuantity": 15
}
------------------------------------------------------------------------------------------------------------
Delete Book by ID
DELETE /books/{id}

Example:

DELETE /books/1
-------------------------------------------------------------------------------------------------------------
Delete All Books
DELETE /books
-------------------------------------------------------------------------------------------------------------
Search Book
GET /books/search?title=Godan
------------------------------------------------------------------------------------------------------------
Get Available Books
GET /books/available
------------------------------------------------------------------------------------------------------------
👨‍🎓 Student APIs
Add Student
POST /students

Request Body:

{
    "name": "Yogita",
    "email": "yogita@gmail.com",
    "phone": "9876543210",
    "city": "Thane"
}
------------------------------------------------------------------------------------------------------------
Get All Students
GET /students
-------------------------------------------------------------------------------------------------------------
Get Student by ID
GET /students/{id}

Example:

GET /students/1
--------------------------------------------------------------------------------------------------------------
Update Student
PUT /students/{id}
-------------------------------------------------------------------------------------------------------------
Delete Student by ID
DELETE /students/{id}
--------------------------------------------------------------------------------------------------------------
Delete All Students
DELETE /students
--------------------------------------------------------------------------------------------------------------
Search Student
GET /students/search?name=Yogita
-------------------------------------------------------------------------------------------------------------
📚 Issue Book APIs
Issue a Book
POST /issues?bookId=1&studentId=1

Example:

POST http://localhost:8080/issues?bookId=1&studentId=1

When a book is successfully issued:

availableQuantity = availableQuantity - 1
status = ISSUED
issueDate = Current Date
Get All Issue Records
GET /issues
---------------------------------------------------------------------------------------------------------
🔄 Return Book API
Return a Book
PUT /issues/{id}/return

Example:

PUT /issues/1/return

When a book is returned:

availableQuantity = availableQuantity + 1
status = RETURNED
returnDate = Current Date
--------------------------------------------------------------------------------------------------------
🧠 Business Logic

Book Issue Flow
----------------
1. Receive bookId and studentId
             ↓
2. Find the book
             ↓
3. Find the student
             ↓
4. Check book availability
             ↓
5. Create issue record
             ↓
6. Decrease available quantity
             ↓
7. Save issue record

Book Return Flow
-------------------
1. Receive issue ID
             ↓
2. Find issue record
             ↓
3. Check return status
             ↓
4. Set return date
             ↓
5. Change status to RETURNED
             ↓
6. Increase available quantity
             ↓
7. Save updated issue record
-------------------------------------------------------------------------------------------------------
⚙️ Configuration

Configure the database connection in:

src/main/resources/application.properties

Example:

spring.application.name=LibraryManagement

spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080

Update the MySQL username and password according to your local environment.
---------------------------------------------------------------------------------------------------------
▶️ How to Run the Project
Prerequisites

Make sure the following are installed:

Java 17 or later
IntelliJ IDEA
MySQL
Maven
Postman
Git
Step 1: Clone the Repository
git clone <your-repository-url>
Step 2: Open the Project

Open the cloned project in IntelliJ IDEA.

Step 3: Create the Database

Open MySQL and execute:

CREATE DATABASE librarydb;
Step 4: Configure Database Credentials

Update:

application.properties

with your MySQL credentials.

Step 5: Build the Project
mvn clean install
Step 6: Run the Application

Run:

LibraryManagementApplication.java

Or use:

mvn spring-boot:run
Step 7: Test APIs

Open Postman and use:

http://localhost:8080
-------------------------------------------------------------------------------------------------------------
🧪 API Testing

The REST APIs can be tested using Postman.

Book Operations
POST    /books
GET     /books
GET     /books/{id}
PUT     /books/{id}
DELETE  /books/{id}
DELETE  /books
GET     /books/search?title=Godan
GET     /books/available
------------------------------------------------------------------------------------------------------------
Student Operations

POST    /students
GET     /students
GET     /students/{id}
PUT     /students/{id}
DELETE  /students/{id}
DELETE  /students
GET     /students/search?name=Yogita
Issue & Return Operations
POST    /issues?bookId=1&studentId=1
GET     /issues
PUT     /issues/{id}/return
---------------------------------------------------------------------------------------------------------
🛡️ Exception Handling

The application uses centralized exception handling through:

ResourceNotFoundException
GlobalExceptionHandler

Examples of handled errors:

Book not found
Student not found
Issue record not found
Book is not available
Book already returned

Global exception handling is implemented using:

@RestControllerAdvice
---------------------------------------------------------------------------------------------------------
📌 Key Concepts Demonstrated

This project demonstrates practical implementation of:

Object-Oriented Programming
Java Classes and Objects
Encapsulation
Dependency Injection
Spring Boot
RESTful Web Services
CRUD Operations
Spring Data JPA
Hibernate ORM
JPA Entity Relationships
MySQL Database Integration
Custom Exception Handling
Global Exception Handling
HTTP Methods
Request Parameters
Path Variables
JSON Request/Response
Postman API Testing
Git & GitHub
-----------------------------------------------------------------------------------------------------------
🔮 Future Enhancements

The following features can be added in future versions:

User authentication and authorization
Admin and student roles
Spring Security
JWT-based authentication
Book due-date management
Fine calculation
Email notifications
Pagination and sorting
Advanced search and filtering
Admin dashboard
Library reports and analytics
Frontend using HTML, CSS and JavaScript
React-based frontend
Cloud deployment
-------------------------------------------------------------------------------------------------------
📸 Screenshots

Screenshots of the application and Postman API responses can be added here.

Example:

docs/
├── book-api.png
├── student-api.png
├── issue-book.png
└── return-book.png

----------------------------------------------------------------------------------------------------------
📈 Project Status
Status: Completed / Learning Project

The project demonstrates a complete backend workflow for managing books, students, and library transactions using Spring Boot and MySQL.

---------------------------------------------------------------------------------------------------------
Java | Spring Boot | Backend Development

Technical Skills
Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
REST API
Postman
Git
GitHub

⭐ If You Find This Project Useful

If this project helped you understand Spring Boot, REST APIs, JPA, and MySQL integration, feel free to star ⭐ the repository.
