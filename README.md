# SunbaseCrud

## Student Management Web Application

This is a Java web application for managing student records. It provides CRUD (Create, Read, Update, Delete) functionality using JDBC, Servlets, and JSPs with MySQL as the database.

## Features

- **Add Student**: Add new student records.
- **View Students**: View a list of all student records.
- **Update Student**: Update existing student records.
- **Delete Student**: Delete student records.
- **Search Students**: Search for student records by keyword.

## Getting Started

### Setting Up the Database

1. Install MySQL and create a database named `student_db`.
2. Run the following SQL script to create the `students` table:
    ```sql
    CREATE DATABASE student_db;

    USE student_db;

    CREATE TABLE students (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL,
        age INT NOT NULL
    );
    ```

### Configuring the Project

1. Clone this repository:
    ```bash
    git clone https://github.com/Manuraj07/SunbaseCrud.git
    cd SunbaseCrud
    ```

2. Open the project in your IDE (e.g., Eclipse, IntelliJ).

3. Configure the database connection in `DBconnect.java`:
    ```java
    package com.DB;

    import java.sql.Connection;
    import java.sql.DriverManager;

    public class DBconnect {
        private static Connection conn;

        public static Connection getConnetion() {
            try {
                if (conn == null) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
    ```
    Replace `your-username` and `your-password` with your MySQL credentials.

### Building and Deploying

1. Build the project using Maven:
    ```bash
    mvn clean install
    ```

2. Deploy the generated WAR file to Apache Tomcat:
   - Copy the WAR file from `target/SunbaseCrud.war` to the `webapps` directory of your Tomcat installation.

3. Start the Tomcat server.

### Accessing the Application

Open your web browser and navigate to `http://localhost:8080/SunbaseCrud`.

## Project Structure


Here is a well-organized and polished version of your README.md file:

markdown
Copy code
# SunbaseCrud

## Student Management Web Application

This is a Java web application for managing student records. It provides CRUD (Create, Read, Update, Delete) functionality using JDBC, Servlets, and JSPs with MySQL as the database.

## Features

- **Add Student**: Add new student records.
- **View Students**: View a list of all student records.
- **Update Student**: Update existing student records.
- **Delete Student**: Delete student records.
- **Search Students**: Search for student records by keyword.

## Getting Started

### Setting Up the Database

1. Install MySQL and create a database named `student_db`.
2. Run the following SQL script to create the `students` table:
    ```sql
    CREATE DATABASE student_db;

    USE student_db;

    CREATE TABLE students (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL,
        age INT NOT NULL
    );
    ```

### Configuring the Project

1. Clone this repository:
    ```bash
    git clone https://github.com/Manuraj07/SunbaseCrud.git
    cd SunbaseCrud
    ```

2. Open the project in your IDE (e.g., Eclipse, IntelliJ).

3. Configure the database connection in `DBconnect.java`:
    ```java
    package com.DB;

    import java.sql.Connection;
    import java.sql.DriverManager;

    public class DBconnect {
        private static Connection conn;

        public static Connection getConnetion() {
            try {
                if (conn == null) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "your-username", "your-password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
    ```
    Replace `your-username` and `your-password` with your MySQL credentials.

### Building and Deploying

1. Build the project using Maven:
    ```bash
    mvn clean install
    ```

2. Deploy the generated WAR file to Apache Tomcat:
   - Copy the WAR file from `target/SunbaseCrud.war` to the `webapps` directory of your Tomcat installation.

3. Start the Tomcat server.

### Accessing the Application

Open your web browser and navigate to `http://localhost:8080/SunbaseCrud`.

## Project Structure

src/main/java
|-- com
| |-- DB
| | -- DBconnect.java | |-- DAO | | -- StudentsDAO.java
| |-- entity
| | -- Students.java | -- servlet
| |-- AddServlet.java
| |-- DeleteServlet.java
| |-- EditServlet.java
| |-- SearchServlet.java
| -- UpdateServlet.java | src/main/webapp |-- AllComponent | |-- allCss.jsp | -- navbar.jsp
|-- add.jsp
|-- list.jsp
|-- update.jsp
|-- index.jsp

## Java Classes

- **DBconnect**: Manages the database connection.
- **StudentsDAO**: Provides methods for database operations related to students.
- **Students**: Represents the student entity.

### Servlets

- `AddServlet`: Handles adding new students.
- `DeleteServlet`: Handles deleting students.
- `EditServlet`: Handles fetching a student's data for editing.
- `SearchServlet`: Handles searching for students by keyword.
- `UpdateServlet`: Handles updating existing students.

### JSP Files

- **index.jsp**: Home page.
- **add.jsp**: Form for adding new students.
- **edit.jsp**: Form for editing existing students.
- **list.jsp**: Displays the list of all students.
- **search.jsp**: Form for searching students.
- **update.jsp**: Form for updating existing students.

### AllComponent

- **allCss.jsp**: Includes CSS stylesheets.
- **navbar.jsp**: Navigation bar.

## Screenshots

### List of All Students

![List of All Students](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/e3976153-df5b-4d28-96c2-fb4e820ac445)

### Add Student

![Add Student](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/04e7030d-d344-4ba7-a08e-783834cd186a)
![Add Student](https://github.com/user-attachments/assets/283a1b62-6510-449d-aff0-1c02365c9fee)

### Delete Student

![Delete Student](![Screenshot 2024-07-11 150839](https://github.com/user-attachments/assets/05832b52-b45b-4ecb-870b-682ac8c1acf5))


### Serch By name or Id 

![Screenshot 2024-07-11 165935](https://github.com/user-attachments/assets/5a5f1202-5b67-4655-b2cc-29b054114e17)

![Screenshot 2024-07-11 165701](https://github.com/user-attachments/assets/331c6b86-7993-4203-85c8-dd293a32baa6)



### Database

![Database](https://github.com/Manuraj07/SunbaseCrud/assets/87747649/e6d77260-8c37-4624-aae4-ecf550ea9515)


