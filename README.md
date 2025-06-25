# JudahCars Backend

This is the backend service for **JudahCars**(FrontEnd at https://github.com/robelnigusse/JudahCars ), a car-related platform built using **Spring Boot** and **Maven**. It provides RESTful APIs for managing features such as messaging, payments, and chats.

## 🚀 Features

- ✅ REST APIs for user interaction  
- 💬 Chat and messaging support  
- 💳 Payment integration  
- 📦 Modular structure for scalability  
- 📁 Maven-based build system  

## 📂 Project Structure

```
JudahCars-Backend/
├── src/
│   └── main/
│       └── java/
│           └── com/example/JudahCars_Backend/
│               ├── Controller/
│               │   ├── ChatController.java
│               │   ├── MessageController.java
│               │   └── PaymentController.java
|               |   └── ProductController.java
│               └── JudahCarsBackendApplication.java
├── pom.xml
└── README.md
and so on......
```

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- PostgreSQL
- Maven
- RESTful API
- JSON

## 🔧 Setup & Run

### Prerequisites

- JDK 17 or newer
- Maven

### Steps to Run

```bash
# Clone the repository
git clone https://github.com/your-username/JudahCars-Backend.git
cd JudahCars-Backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# CREATE A DB NAMED JudahCars in PostgreSQL
psql -U your_username -d postgres -c "CREATE DATABASE \"JudahCars\";"
or
CREATE DATABASE "JudahCars";

```

The server will start at: `http://localhost:9090`

## 📫 API Endpoints

| Method | Endpoint         | Description         |
|--------|------------------|---------------------|
| GET    | `/api/chats`     | Get all chats       |
| POST   | `/api/messages`  | Send a new message  |
| POST   | `/api/payments`  | Process a payment   |
| GET    | `/api/products`  | Get all products    |

_(More endpoints available in controllers)_

## 🧑‍💻 Development

- Clone the repo and open it with your IDE (IntelliJ, VS Code, etc.)
- Edit or add new controllers/services as needed
- Build with Maven and test locally

## FrontEnd(React)
- Can be found at https://github.com/robajo1/JudahCars.git

### 🙌 Contributions

Feel free to fork, open issues, or submit pull requests if you'd like to contribute.
