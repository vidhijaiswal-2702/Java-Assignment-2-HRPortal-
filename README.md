# Java-Assignment-2-HRPortal-
# HR Portal

This is a web-based **HR Portal** application built using **Spring Boot** (Backend) and **HTML, CSS, JavaScript** (Frontend). It allows HR Managers to manage employee data with CRUD operations.

## Prerequisites

Before running the project, make sure you have the following installed:

- **Java 11+**
- **Maven**
- **PostgreSQL**

## Project Setup and Running Instructions

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone <repository_url>
cd <project_directory>

## 2. Configure PostgreSQL

Make sure PostgreSQL is installed and running. Create a new database for the project (e.g., `hr_portal_db`).

Update `src/main/resources/application.properties` with your PostgreSQL connection details:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hr_portal_db
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

## 3. Build and Run the Application

### Using Eclipse

1. Open the project in **Eclipse**.
2. Right-click the project → **Run As** → **Spring Boot App**.

### Using Command Line

1. Open the terminal in the project directory.
2. Run the following command to start the Spring Boot application:

   ```bash
   ./mvnw spring-boot:run


## 4. Access the Frontend
Once the application is running, open your browser and go to:

http://localhost:8080/index.html

#### You should be able to see the login page.

## Notes:
Frontend files are located in src/main/resources/static.

If you're running the frontend separately (e.g., with VSCode or Live Server), you can directly open index.html in a browser for testing.


### Steps:

1. **Clone the repository**: The first step for setting up the project.
2. **Configure PostgreSQL**: How to configure the PostgreSQL database.
3. **Build and Run**: Instructions for running the project, both via Eclipse or command line.
4. **Access Frontend**: Details for accessing the frontend after the application is running.

This should work perfectly for your needs! Simply copy and paste it into a new `README.md` file in the root of your project.






