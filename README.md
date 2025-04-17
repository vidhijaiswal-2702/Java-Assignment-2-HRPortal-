## HR Portal

A web-based HR management portal built with **Spring Boot**, **PostgreSQL**, and a modern **HTML/CSS/JavaScript** frontend. It allows for CRUD operations on employees through a clean UI and RESTful backend.

---

## 🛠️ 1. Clone the Repository

```bash
git clone <repository_url>
cd <project_directory>
🗄️ 2. Configure PostgreSQL
Make sure PostgreSQL is installed and running on your machine. Create a database named hr_portal_db (or any name you prefer). Update your database credentials in the following file:

Path: src/main/resources/application.properties

Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/hr_portal_db
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
🚀 3. Build and Run the Application
✅ Using Eclipse
Open the project in Eclipse IDE. Right-click the project → Run As → Spring Boot App.

💻 Using Command Line
Navigate to your project folder and run:

Bash

./mvnw spring-boot:run
After a few seconds, your backend will be up and running at:

http://localhost:8080
🌐 4. Access the Frontend
Once the Spring Boot app is running, open your browser and go to:

http://localhost:8080/index.html
✅ You should see the HR Portal login or dashboard page (depending on your setup).

🗂️ Notes
All frontend files (index.html, dashboard.html, CSS, JS) are located in:

src/main/resources/static/
You can also test the frontend separately (e.g., with Live Server in VS Code) by simply opening index.html in your browser.

📋 Summary of Steps
Clone the repository
Configure PostgreSQL database
Build and run the Spring Boot app
Open the frontend in browser at http://localhost:8080/index.html












