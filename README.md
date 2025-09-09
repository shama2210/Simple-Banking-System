#  Simple Banking System (Java + MySQL)

A simple **Banking System** built with **Java Swing** for the GUI and **MySQL** as the database.  
This project demonstrates **OOP concepts**, database connectivity using **JDBC**, and basic banking operations.

---
##  Features
- User **Login**
- **Deposit** and **Withdraw** money
- **Balance Enquiry**
- Secure **PIN-based authentication**
- Simple **Swing GUI**

---

##  Database Setup

1. Open MySQL and create the database:
   
   CREATE DATABASE bank;
   USE bank;


2. Create `users` table:

   ```sql
   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       acc_no INT UNIQUE NOT NULL,
       pin INT NOT NULL,
       phone VARCHAR(15),
       email VARCHAR(100),
       balance DECIMAL(10,2) DEFAULT 0
   );
   ```

3. Insert sample user:

   ```sql
   INSERT INTO users (name, acc_no, pin, phone, email, balance)
   VALUES ('user', 1111, 1234, '9999999999', 'user@example.com', 7723);
   ```

---

## Project Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/shama2210/Simple-Banking-System.git
   cd banking-system
   ```

2. Import the project into your **IDE** (Eclipse, IntelliJ, or VS Code with Java extension).

3. Add **MySQL Connector JAR** to your project’s classpath:

   * [Download MySQL Connector](https://dev.mysql.com/downloads/connector/j/)

4. Update DB credentials in your code (usually in `DB.java`):

   ```java
   String url = "jdbc:mysql://localhost:3306/bank";
   String user = "root";
   String pass = "yourpassword";
   ```

5. Compile and run:

   ```bash
   javac -cp .:mysql-connector-java-8.0.33.jar *.java
   java -cp .:mysql-connector-java-8.0.33.jar Main
   ```

   > On Windows, replace `:` with `;`

---

##  Project Structure

```
banking-system/
├── DB.java          # Database connection
├── BankOps.java     # All operations (deposit, withdraw, balance)
├── MainApp.java     # Swing GUI
├── users.sql        # Schema for users table
├── README.md
```

---




---




