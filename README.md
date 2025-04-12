# Java-Assignment-2-HRPortal-
## Project Overview

This HR Portal is a web application designed to manage employee information and handle basic HR functionalities. It provides a user-friendly interface for HR personnel to view, add, edit, and delete employee records. Additionally, it includes a basic HR user authentication system with registration and login capabilities.

## Table of Contents

1.  [Project Structure](#project-structure)
2.  [Backend Details](#backend-details)
    * [Model Layer](#model-layer)
    * [Repository Layer](#repository-layer)
    * [Service Layer](#service-layer)
    * [Controller Layer](#controller-layer)
3.  [Frontend Details](#frontend-details)
    * [HTML Templates](#html-templates)
    * [CSS Stylesheets](#css-stylesheets)
    * [JavaScript Files](#javascript-files)
4.  [How to Run the Application](#how-to-run-the-application)
5.  [API Endpoints](#api-endpoints)
6.  [Database Details](#database-details)
7.  [Future Enhancements](#future-enhancements)



## 1. Project Structure

The project follows a standard Spring Boot MVC (Model-View-Controller) architecture. The main directories are:

HR-Portal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/hr_portal/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       │   └── impl/
│   │   │       └── HrPortalApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── css/
│   │   │   │   └── js/
│   │   │   └── templates/
│   │   └── application.properties
│   └── test/
│       └── java/
│           └── com/example/hr_portal/
├── .gitignore
└── README.md


## 2. Backend Details

The backend is built using Java and the Spring Boot framework.

### Model Layer (`src/main/java/com/example/hr_portal/model/`)

This layer contains the data models (Entities) that represent the tables in the database:

* **`Employee.java`**: Represents an employee with attributes like `id`, `name`, `department`, `email`, and `salary`. Annotated with `@Entity` and `@Table(name = "employees")`.
* **`HR.java`**: Represents an HR user with attributes like `id`, `email`, and `password`. Annotated with `@Entity` and `@Table(name = "hr_users")`.

### Repository Layer (`src/main/java/com/example/hr_portal/repository/`)

This layer contains interfaces that extend Spring Data JPA's `JpaRepository`. These interfaces provide methods for database interaction:

* **`EmployeeRepository.java`**: Provides CRUD operations for the `Employee` entity.
* **`HRRepository.java`**: Provides CRUD operations for the `HR` entity, including a custom method `findByEmail` to find HR users by their email.

### Service Layer (`src/main/java/com/example/hr_portal/service/` and `src/main/java/com/example/hr_portal/service/impl/`)

This layer contains interfaces and their implementations that handle the business logic of the application:

* **`EmployeeService.java`**: Interface defining operations for managing employees (e.g., `getAllEmployees`, `saveEmployee`, `getEmployeeById`, `deleteEmployee`).
* **`EmployeeServiceImpl.java`**: Implementation of `EmployeeService`.
* **`HRService.java`**: Interface defining operations for managing HR users (e.g., `registerHR`, `findHRByEmail`).
* **`HRServiceImpl.java`**: Implementation of `HRService`.

### Controller Layer (`src/main/java/com/example/hr_portal/controller/`)

This layer contains Spring MVC controllers that handle incoming web requests and interact with the service layer to process data and render views:

* **`EmployeeController.java` (formerly `HRController.java`)**: Handles requests related to employee management:
    * `@GetMapping("/dashboard")`: Displays the employee dashboard (`dashboard.html`).
    * `@GetMapping("/employees/add")`: Displays the form to add a new employee (`add_employee.html`).
    * `@PostMapping("/employees/add")`: Saves a new employee to the database.
    * `@GetMapping("/employees/edit/{id}")`: Displays the form to edit an existing employee (`edit_employee.html`).
    * `@PostMapping("/employees/edit/{id}")`: Updates an existing employee in the database.
    * `@GetMapping("/employees/delete/{id}")`: Deletes an employee from the database.
* **`HRAuthController.java`**: Handles requests related to HR user authentication:
    * `@GetMapping("/")`: Displays the landing page (`index.html`).
    * `@GetMapping("/login")`: Displays the HR login form (`login.html`).
    * `@PostMapping("/login")`: Authenticates HR users.
    * `@GetMapping("/register")`: Displays the HR registration form (`register.html`).
    * `@PostMapping("/register")`: Registers new HR users.

## 3. Frontend Details

The frontend is built using HTML, CSS, and basic JavaScript. Thymeleaf is used as the template engine to dynamically render data from the backend.

### HTML Templates (`src/main/resources/templates/`)

These files define the structure and content of the web pages:

* **`index.html`**: The landing page with links to login and registration.
* **`login.html`**: The HR login form.
* **`register.html`**: The HR registration form.
* **`dashboard.html`**: Displays the list of employees with options to add, edit, and delete.
* **`add_employee.html`**: Form to add a new employee.
* **`edit_employee.html`**: Form to edit an existing employee.

### CSS Stylesheets (`src/main/resources/static/css/`)

These files contain the styling for the web pages:

* **`style.css`**: Contains general styling for the application, including form elements, tables, and basic layout.
* **`landing.css`**: Contains specific styling for the landing page (`index.html`).

### JavaScript Files (`src/main/resources/static/js/`)

These files contain client-side scripting for interactivity:

* **`script.js`**: Currently contains the logic for confirming employee deletion before making the request to the backend.

## 4. How to Run the Application

1.  **Prerequisites:**
    * Java Development Kit (JDK) 17 or higher.
    * Maven.
    * A database (configured in `application.properties`, default is H2 in-memory).
    * An IDE like Eclipse or IntelliJ IDEA (optional, but recommended).

2.  **Steps:**
    * **Using an IDE:**
        * Import the project as a Maven project.
        * Run the `HrPortalApplication.java` file as a Spring Boot application.
    * **Using Maven from the command line:**
        * Navigate to the project root directory in your terminal.
        * Run the command: `mvn spring-boot:run`

3.  **Access the Application:**
    * Once the application starts, open your web browser and navigate to `http://localhost:8080/`.

## 5. API Endpoints

While this is primarily a web application with HTML rendering, the following URLs trigger backend logic:

* **`GET /`**: Displays the landing page.
* **`GET /login`**: Displays the login form.
* **`POST /login`**: Handles HR user login.
* **`GET /register`**: Displays the registration form.
* **`POST /register`**: Handles HR user registration.
* **`GET /dashboard`**: Displays the employee dashboard.
* **`GET /employees/add`**: Displays the add employee form.
* **`POST /employees/add`**: Adds a new employee.
* **`GET /employees/edit/{id}`**: Displays the edit employee form for a specific employee ID.
* **`POST /employees/edit/{id}`**: Updates a specific employee.
* **`GET /employees/delete/{id}`**: Deletes a specific employee.

## 6. Database Details

The application is currently configured to use an **H2 in-memory database** by default. This is suitable for development and testing. The database configurations can be found in the `src/main/resources/application.properties` file.

To use a persistent database (like MySQL, PostgreSQL, etc.), you will need to:

1.  Add the appropriate database dependency to the `pom.xml` file.
2.  Update the database connection properties in `application.properties` (e.g., `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`, `spring.datasource.driver-class-name`).

## 7. Future Enhancements

* Implement proper user roles and authorization.
* Add more advanced HR functionalities (e.g., leave management, payroll).
* Improve frontend UI/UX with a more robust framework (e.g., React, Angular).
* Implement input validation on both frontend and backend.
* Add unit and integration tests.
* Implement password hashing for HR user security.
* Implement error handling and user feedback for various operations.


