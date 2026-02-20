# BankMasking
Project to mask user information


Books API Demo
Simple Spring Boot 3+ CRUD application with configurable sensitive data masking.

Requirements
• Java 17+
• Maven 3+

Run the Application
1. Build bank-parent
   mvn clean install
   This will build the library and app at one go.
   
2. Build the masking starter (first time only) - Optional
cd bank-masking-spring-boot-starter
mvn clean install

3. Run the API
cd bank-books-api-demo
mvn spring-boot:run
OR
mvn clean package
java -jar target/books-api-demo-0.0.1-SNAPSHOT.jar

Access
API: http://localhost:8080/books/ - You should see the message - ”Welcome to Bank Books API!”
Swagger: http://localhost:8080/swagger-ui.html
H2 Console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:booksdb
Username: sa
Password: (empty)

Masking Configuration
Configured in: src/main/resources/application.yaml
Example:
bank:
  masking:
    enabled: true
    fields:
      - email
      - phoneNumber
