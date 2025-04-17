# README.md

## HR Portal

A web-based HR management portal built with **Spring Boot**, **PostgreSQL**, and a modern **HTML/CSS/JavaScript** frontend. It allows for CRUD operations on employees through a clean UI and RESTful backend.

---

## 🛠️ 1. Clone the Repository

```bash
git clone <repository_url>
cd <project_directory>

## 🗄️ 2. Configure PostgreSQL

Make sure PostgreSQL is installed and running on your machine. Create a database named `hr_portal_db` (or any name you prefer). Update your database credentials in the following file:

**Path:** `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hr_portal_db
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect










