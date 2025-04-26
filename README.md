# React-SpringBoot-Coin-App

A full-stack application for managing Coins and Mints, built with **Spring Boot** backend and **React** frontend.\
This repository contains the backend REST API service.

---

## 🚀 Features

- Manage **Coins** with descriptions, weights, prices, metals, mint relationships.
- Manage **Mints** and list associated Coins.
- Full **validation** on inputs using `@Valid` and DTOs.
- **Exception handling** with custom clean error responses (no raw stack traces).
- **Global error handler** for missing entities, bad input, constraint violations.
- **Database constraints** enforced for uniqueness and foreign keys.
- Clean separation: Controller → Service → Repository → Entity/DTO → Mapper.
- Designed for **extensibility**: ready to add security, pagination, advanced querying, and tests.

---

## 🛠️ Technologies

- Java 21
- Spring Boot 3
- Spring Data JPA (Hibernate)
- MySQL Database
- Docker / Docker Compose (for easy environment setup)
- Maven

---

## 🐳 Docker Setup

The project uses Docker for local development to start a **MySQL database** automatically.

### 🛠️ Run database with Docker:

```bash
docker-compose up -d
```

This spins up a MySQL container named `coin-db` using the configuration provided in `docker-compose.yml`.

✅ **Default database:** `coin_db`\
✅ **Username:** `root`\
✅ **Password:** `password`

> If you don't have Docker installed, see: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)

---

## 🌍 Application Profiles

The backend runs with **Spring Profiles** to manage environments.

- By default, it runs with the **`dev`**** profile**.
- Configuration is set in `application-dev.properties`:
    - Connects to local Docker MySQL database.
    - Enables debugging and detailed error output for development.

```bash
# Example run
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

✅ No manual database setup needed — just start Docker and run the app!

---

## 📦 API Endpoints

| Method | Path                         | Description              |
| ------ | ---------------------------- | ------------------------ |
| POST   | `/api/coins`                 | Create a new Coin        |
| GET    | `/api/coins`                 | List all Coins           |
| GET    | `/api/coins/{id}`            | Get a Coin by ID         |
| PUT    | `/api/coins/{id}`            | Update a Coin            |
| DELETE | `/api/coins/{id}`            | Delete a Coin            |
| POST   | `/api/mints`                 | Create a new Mint        |
| GET    | `/api/mints`                 | List all Mints           |
| GET    | `/api/mints/{id}`            | Get a Mint by ID         |
| PUT    | `/api/mints/{id}`            | Update a Mint            |
| DELETE | `/api/mints/{id}`            | Delete a Mint            |
| GET    | `/api/mints/{id}/with-coins` | Get a Mint and its Coins |

All responses are in clean JSON format, with consistent error handling.

---

## 👋 Future Improvements (Planned)

- **Add unit and integration tests** (with a dedicated `test` Spring profile).
- **Setup H2 in-memory database for testing** instead of using Docker for test runs.
- **Add pagination and sorting** for listing Coins and Mints.
- **Enhance validation and error codes** for better frontend integration.
- **Add Swagger/OpenAPI Documentation** for easier API exploration.

---

## ✅ How to Contribute

- Fork the repository
- Create a feature branch
- Open a pull request with a clear description

---

## 🤝 License

This project is licensed under the MIT License.

---

# 🌟 Quick start checklist:

```bash
# 1. Start MySQL with Docker
docker-compose up -d

# 2. Run the app (development profile)
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

---

# 📢 Notes

- Do **NOT delete a Mint** if it still has Coins — the app protects against that with safe checks.
- Validation is fully handled — missing fields, duplicate descriptions, and bad input will return friendly JSON errors.

---

# 🏆 Authors

**Daniel Devlin**\
Built with ❤️ and clean architecture principles!