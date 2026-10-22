# User Management System — Backend

A RESTful backend for a full-stack User Management System, built with Java 21, Spring Boot, Spring Data JPA, and MySQL.

**[Live Frontend Demo](https://user-management-system-frontend-swart.vercel.app/)** · **[Frontend Repository](https://github.com/Anish-D1/user-management-system-frontend)** · **[Backend Repository](https://github.com/Anish-D1/user-management-system-backend)**

## Features

- REST API for creating, retrieving, updating, and deleting users.
- Persistent storage using MySQL.
- Database operations using Spring Data JPA and Hibernate.
- Request validation and structured error handling.
- Unique email constraint to prevent duplicate email addresses.
- HTTP status codes for successful requests, validation errors, missing users, and database constraint violations.
- Environment-based database credentials.
- Deployment support using Docker and Render.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot | Application framework |
| Spring Web | REST endpoints |
| Spring Data JPA | Database access |
| Hibernate | ORM |
| MySQL | Relational database |
| Maven | Dependency and build management |
| Docker | Containerized deployment |
| Render | Backend hosting |
| Aiven | Hosted MySQL database |
| Git and GitHub | Version control |

## Architecture

```text
React Frontend
      |
      | HTTP / JSON
      v
Spring Boot REST API
      |
      | Spring Data JPA / Hibernate
      v
MySQL Database
```

## Live Services

**Frontend:** https://user-management-system-frontend-swart.vercel.app/

**Backend API:** https://user-management-system-backend-y9fz.onrender.com/api/users

The backend root URL is not a user-facing page. Use the `/api/users` endpoint to retrieve user records.

## API Endpoints

Base URL:

```text
/api/users
```

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/users` | Retrieve all users |
| POST | `/api/users` | Create a user |
| PUT | `/api/users/{id}` | Update a user |
| DELETE | `/api/users/{id}` | Delete a user |

### Example request

Create a user with `POST /api/users`:

```json
{
  "name": "Demo User",
  "email": "demo@example.com"
}
```

### Error handling

| HTTP status | Meaning |
|---|---|
| 400 Bad Request | Request validation failed |
| 404 Not Found | Requested user does not exist |
| 409 Conflict | Duplicate email or another database constraint violation |

## Run Locally

### Prerequisites

- Java 21
- Maven (or the included Maven wrapper, if available)
- MySQL

### 1. Clone the repository

```bash
git clone https://github.com/Anish-D1/user-management-system-backend.git
cd user-management-system-backend
```

### 2. Configure environment variables

Set the following environment variables before starting the application:

```text
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

The database URL is configured in `src/main/resources/application.properties`. Ensure it points to a MySQL database you control, and that the database exists.

**Never commit real database passwords or credentials to GitHub.**

### 3. Start the application

Using Maven:

```bash
mvn spring-boot:run
```

The application runs on port `8080` by default, unless overridden by the `PORT` environment variable.

### 4. Test the API

Retrieve users:

```bash
curl http://localhost:8080/api/users
```

Create a user:

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Demo User\",\"email\":\"demo@example.com\"}"
```

## Deployment

The backend is deployed on Render and connects to a hosted MySQL database on Aiven.

Environment variables are used to configure database credentials without hardcoding secrets in the source code.

## What I Practised

- Designing RESTful API endpoints.
- Implementing CRUD operations with Spring Boot.
- Mapping Java entities to MySQL tables.
- Handling validation and database exceptions.
- Enforcing unique constraints at the database level.
- Configuring environment variables for deployment.
- Deploying a Java backend with a hosted relational database.

## Security Note

Authentication and authorization have not yet been implemented. This project is intended for portfolio demonstration. Do not use it to store real personal or sensitive data.

## Author

**Anish Devan**

Aspiring Java Full-Stack Developer

[GitHub Profile](https://github.com/Anish-D1)
