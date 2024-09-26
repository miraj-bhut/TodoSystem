# TheTreasure - TodoSystem

## Overview

**TheTreasure** is a Spring Boot-based web application designed for managing tasks and user authentication. It allows users to create, update, delete, and manage tasks while ensuring secure access through authentication and role-based authorization. This project serves as a foundation for learning and working with Spring Boot, Spring Security, and other modern Java frameworks.

## Features

- User authentication and authorization with Spring Security
- Role-based access control
- CRUD operations for managing tasks
- Integration with a database (PostgreSQL)
- RESTful API endpoints

## Tech Stack

- **Backend:** Java, Spring Boot, Spring Security, JPA (Hibernate)
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Version Control:** Git

## Prerequisites

Before running the project, ensure you have the following installed:

- Java 17+
- Maven 3.8+
- PostgreSQL (or your preferred database)
- Git

## Setup Instructions

1. **Configure PostgreSQL:**
    
    Update the `application.properties` file with your database credentials.
    
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    
    
2. **Access the application:**
    
    The application will be accessible at http://localhost:8080.
    

## Endpoints

| Method | Endpoint | Description |

| GET | /getAllTask | Retrieve all tasks |
| GET | /gatTask/{id} | get particular task |
| POST | /addUser | Create new user |
| POST | /addTask | Create a new task |
| POST | /updateTask/{id} | Update an existing task |
| DELETE | /DeleteTask/{id} | Delete a task by ID |

## License

This project is licensed under the APACHE 2.0 License.
