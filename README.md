# Simple Signup/Login API with Java Spring Boot
This project demonstrates a basic implementation of a Signup and Login API using Java Spring Boot. It provides endpoints for user authentication and registration, along with password encryption and simple security configurations.

Features
User Registration: Allows users to create an account with email and password.
User Login: Authenticates users and validates credentials.
Password Encryption: Uses BCrypt for secure password storage.
RESTful API: Clean and organized endpoints for client-server communication.

Technologies Used
  Java 17+
  Spring Boot
  Spring Data JPA
  Spring Security
  MySQL (configurable) for database
  Maven for dependency management

API Endpoints
Authentication
POST /signup: Register a new user.
POST /login: Authenticate a user.

User Management
GET /api/v1/user/get: Get all users.
GET /api/v1/user/get/{id}: Get user by ID.
POST /api/v1/user/create: Create a new user.
PUT /api/v1/user/update/{id}: Update user details.
DELETE /api/v1/user/delete/{id}: Delete a user.
