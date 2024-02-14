Quiz Application
    The Quiz Application is a web-based system designed to facilitate quizzes in various categories. This application allows users to create quizzes, attempt them, and receive scores based on their responses. It provides functionalities for administrators to manage quizzes and questions effectively.

Table of Contents
    Features
    Technologies Used
    Setup
    Usage

Features
    Quiz Creation: Users can create quizzes by selecting questions from predefined categories.
                  Random Question Selection: The application randomly selects questions from the chosen category for each quiz.
    Quiz Attempt: Users can attempt quizzes and submit their responses.
    Scoring: The application automatically scores the quiz based on the user's responses.
    Admin Panel: Administrators have access to manage quizzes, including adding new questions and categories.
    Responsive Design: The application is designed to be responsive, supporting various devices.

Technologies Used
    Spring Boot: Framework for building robust Java applications.
    Spring Data JPA: Simplifies data access in the Spring application.
    Hibernate: Object-relational mapping tool for the Java platform.
    Lombok: Library to reduce boilerplate code in Java classes.
    RESTful API: Design pattern for building scalable web services.
    PostgresSQL: Relational database management system for data storage.

Setup
    Clone the Repository:
        git clone https://github.com/Aviralkumar2003/Quiz-API.git

    Database Configuration:
        Install PostgresSQL and create a database named quiz_db.
        Update the database configuration in application.properties.

    Build and Run:
        cd quiz-app
        mvn spring-boot:run
    
    Access the Application:
        Open a web browser and go to http://localhost:8080.

Usage
    User: Sign up or log in to the application to access quizzes. Attempt quizzes and view scores.
    Admin: Log in as an admin to access the admin panel. Manage quizzes, add questions, and categories.
