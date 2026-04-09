# 🚇 Metro Ticket Backend System

## 📌 Project Overview

This project is a **backend system for a metro ticketing application** built using Spring Boot. 
It allows users to book tickets, validate entry and exit, and ensures proper usage through expiry and validation logic.

---

## 🚀 Features

* 🎫 Book Metro Ticket
* 🔍 Get Ticket Details by ID
* 🚉 Entry Validation (only once)
* 🚪 Exit Validation (only after entry)
* ⏱️ Ticket Expiry (valid for 18 hours)
* ❌ Prevent misuse (duplicate entry/exit not allowed)

---

## 🏗️ Architecture

The project follows a **layered architecture**:

```
Controller → Service → Repository → Database
```

* **Controller** → Handles API requests
* **Service** → Contains business logic
* **Repository** → Handles database operations
* **Database** → Stores ticket data

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Hibernate
* Postman (for API testing)

---

## 📂 Project Structure

```
com.metroApp.metroTicket
│
├── controller
│   └── TicketController.java
│
├── service
│   └── TicketService.java
│
├── repository
│   └── TicketRepository.java
│
├── model
│   └── Ticket.java
│
└── MetroTicketApplication.java
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```
git clone <your-repo-link>
cd metro-ticket
```

### 2️⃣ Configure Database (PostgreSQL)

Update `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/metrodb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run the Application

Run the main class:

```
MetroTicketApplication.java
```

Server will start at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### 🎫 Book Ticket

* **POST** `/ticket/book?source=Delhi&destination=Noida`

---

### 🔍 Get Ticket

* **GET** `/ticket/{id}`

---

### 🚉 Entry

* **POST** `/ticket/entry/{id}`

---

### 🚪 Exit

* **POST** `/ticket/exit/{id}`

---

## 🧪 Testing

All APIs were tested using Postman.

### Flow:

1. Book Ticket
2. Use ID for Entry
3. Use same ID for Exit

---

## ⚠️ Validations Implemented

* Entry allowed only once
* Exit allowed only after entry
* Ticket expires after 18 hours
* Invalid ticket ID handled
* Duplicate usage prevented

---

## 🎯 Conclusion

This project demonstrates:

* Backend development using Spring Boot
* REST API design
* Database integration
* Business logic implementation

---

## 👨‍💻 Author

**Ankit Gupta**

---
