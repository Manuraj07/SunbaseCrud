# SunbaseCrud
CRUD Operation

# Student Management Web Application

This is a Java web application for managing student records. It provides CRUD (Create, Read, Update, Delete) functionality using JDBC, Servlets, and JSPs with MySQL as the database.

## Features

- **Add Student**: Add new student records.
- **View Students**: View a list of all student records.
- **Update Student**: Update existing student records.
- **Delete Student**: Delete student records.
- **Search Students**: Search for student records by keyword.

### Setting Up the Database

1. Install MySQL and create a database named `student_db`.
2. Run the following SQL script to create the `students` table:

```sql
CREATE DATABASE studentdb;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    age INT NOT NULL
);


List of All the Students
![Screenshot 2024-07-11 145859](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/e3976153-df5b-4d28-96c2-fb4e820ac445)


Add to Students

![Screenshot 2024-07-11 150656](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/04e7030d-d344-4ba7-a08e-783834cd186a)

Delete the Student


![Screenshot 2024-07-11 150720](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/ae0185ee-a7ee-428b-bda9-ac6cf3b1f226)


Project Setup

src/main/java
|-- com
|   |-- DB
|   |   `-- DBconnect.java
|   |-- DAO
|   |   `-- StudentsDAO.java
|   |-- entity
|   |   `-- Students.java
|   `-- servlet
|       |-- AddServlet.java
|       |-- DeleteServlet.java
|       |-- EditServlet.java
|       |-- SearchServlet.java
|       `-- UpdateServlet.java
|
src/main/webapp
|-- AllComponent
|   |-- allCss.jsp
|   `-- navbar.jsp
|-- add.jsp
|-- list.jsp
|-- update.jsp


![Screenshot 2024-07-11 165701](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/86cfe271-3914-49c5-b0a9-9e9c40adad50)

DataBases

![Screenshot 2024-07-11 151024](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/e6d77260-8c37-4624-aae4-ecf550ea9515)

Java Classes
    DBconnect: Manages the database connection.
    StudentsDAO: Provides methods for database operations related to students.
    Students: Represents the student entity.
Servlets:
    AddServlet: Handles adding new students.
    DeleteServlet: Handles deleting students.
    EditServlet: Handles fetching a student's data for editing.
    SearchServlet: Handles searching for students by keyword.
    UpdateServlet: Handles updating existing students.
JSP Files
    index.jsp: Home page.
    add.jsp: Form for adding new students.
    edit.jsp: Form for editing existing students.
    list.jsp: Displays the list of all students.
    search.jsp: Form for searching students.
    update.jsp: Form for updating existing students.
AllComponent:

    allCss.jsp: Includes CSS stylesheets.
    navbar.jsp: Navigation bar.



