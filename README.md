
# 🎓 Online Learning Management System (LMS)

Welcome to the **Online LMS**, a backend system built with **Spring Boot** to manage courses, students, quizzes, and results — all with clean role-based access for both students and admins.

This project was developed as part of an internship submission and focuses on a scalable backend architecture with JWT authentication, course and quiz management, and user progress tracking.

---

## 🧩 What It Does

### 👨‍🎓 For Students
- Register and log in securely
- Browse and enroll in courses
- Track course completion
- Attempt quizzes
- View quiz results

### 🛠️ For Admins
- Add, edit, and delete courses
- Create and manage quizzes
- View enrolled students

---

## 🚀 Tech Stack

- **Java 17** + **Spring Boot**
- **Spring Security + JWT** for authentication
- **PostgreSQL** for data persistence
- **JPA (Hibernate)** for ORM
- **JUnit + Mockito** for testing

---

## 📚 API Overview

### Authentication
- `POST /auth/signup` — Register new user
- `POST /auth/login` — Login and receive token

### Student APIs
- `GET /student/courses`
- `GET /student/progress/{userId}`
- `GET /student/quiz/{courseId}`
- `POST /student/submit-quiz`
- `GET /student/results/{userId}`

### Admin APIs
- `GET /admin/courses`
- `POST /admin/courses`
- `PUT /admin/courses/{id}`
- `DELETE /admin/courses/{id}`
- `POST /admin/quizzes`

---

## 🛡️ Security

- JWT-based authentication
- Role-based access (`ADMIN` / `STUDENT`)
- CORS configuration for frontend integration

---

## ⚙️ Running the Project

### Requirements
- Java 17
- Maven
- PostgreSQL or H2 (dev)

### Steps

```bash
# 1. Clone the project
git clone https://github.com/your-username/LMS_Project.git

# 2. Navigate into the folder
cd lms-backend

# 3. Run the Spring Boot application
./mvnw spring-boot:run
```

---


---

## ✅ Project Status

✅ Backend is fully functional  
❌ Frontend not included (this repo focuses on backend only)

---



