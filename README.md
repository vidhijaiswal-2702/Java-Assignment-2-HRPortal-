# Java-Assignment-2-HRPortal-
# HR Portal

This is a web-based **HR Portal** application built using **Spring Boot** (Backend) and **HTML, CSS, JavaScript** (Frontend). It allows HR Managers to manage employee data with CRUD operations.

## Prerequisites

Before running the project, make sure you have the following installed:

- **Java 11+**
- **Maven**
- **PostgreSQL**

## Project Setup and Running Instructions

# HR Portal - Spring Boot & PostgreSQL Project

## 1. Clone the Repository

```bash
git clone <repository_url>
cd <project_directory>
2. Configure PostgreSQL
Make sure PostgreSQL is installed and running.
Create a new database for the project (e.g., hr_portal_db).

Update the file: src/main/resources/application.properties with your PostgreSQL credentials:

properties
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/hr_portal_db
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
3. Build and Run the Application
Using Eclipse
Open the project in Eclipse.

Right-click the project → Run As → Spring Boot App.

Using Command Line
Open the terminal inside your project directory and run:

bash
Copy
Edit
./mvnw spring-boot:run
The application will start at: http://localhost:8080

4. Access the Frontend
After running the backend, open your browser and go to:

text
Copy
Edit
http://localhost:8080/index.html
You should see the HR Portal login page.

Notes
All frontend files are located in: src/main/resources/static

If you want to test frontend separately using Live Server (VS Code), you can open index.html directly in your browser without any backend.

Summary of Steps
Clone the repository: First step for setting up the project.

Configure PostgreSQL: Set up the database with credentials.

Build and Run: Run project via Eclipse or command line.

Access Frontend: Open index.html from static folder or browser.










