# StarWars Application

This project is an application based on **Spring Boot** that exposes an API to get pricing information.

## 🚀 Deployment

Once deployed, the endpoints will be available at the following URL:

```
http://localhost:8080/price
```

## 📂 Project Structure

The project structure follows the standard **Spring Boot** architecture:

```
starwars-application/
│── src/
│   ├── main/
│   │   ├── java/com/example/starwars/
│   │   ├── resources/
│── pom.xml
│── docker-compose.yml
│── README.md
│── images

```

## ⚙️ Sonar Images

Contains screenshots of local Sonar with the generated report.

SonarCloud is added with GitHub Actions, where two iterations are made: execution and test execution.


## ⚙️ **Architecture and Design**

- **Contract**: Exposure of the REST controllers.
- **Domain**: Business logic and entities.
- **Application**: Orchestration of business logic.
- **Infrastructure**: Implementation of repositories and persistence.

## ⚙️ Technologies Used
```bash

Java 17
Spring Boot 3.x
H2 Database (en memoria para pruebas)
JUnit 5 & Mockito
Maven
Docker & Docker Compose
Lombok
JaCoCo (para cobertura de código)
SonarCloud (para análisis de calidad)
OpenApi

```

## 🔧 Step 1: Project Setup

### 1. Clone or Extract the Project

If you have downloaded the project as a ZIP file, extract it. If you are using Git, clone the repository:

git clone https://github.com/Fuejaime/BCNC---TEST.git
cd starwars-application


## 🐳 Step 2: Build with Docker (Optional)

If you want to run the application inside a Docker container, follow these steps:

### 1. Build the Docker image using Docker Compose

```bash
docker-compose build
```

### 2. Start the services with Docker Compose

```bash
docker-compose up
```

## 🛠️ Step 3: Build and Run with Maven

Si prefieres ejecutar la aplicación sin Docker, sigue estos pasos:

### 1. Compile the source code

```bash
mvn clean compile
```

### 2. Build the project and generate the JAR

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

Or run the main class directly:


```bash
java -jar target/starwars-application.jar
```

## 🌐 Step 4: Test the API

You can test the API using Postman or cURL.

### 1. Test with Postman

Import the provided Postman collection and run the corresponding request.

### 2.  Test with cURL

The API exposes the following endpoint:

**GET/price**

Example requests:
```bash
curl --location 'http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-15T10:00:00' \
--data ''
```

## 📌 API Parameters

**IN**

| Parámetro        | Tipo   | Descripción |
|-----------------|--------|-------------|
| `productId`     | Number | Product ID |
| `brandId`       | Number | Brand ID |
| `applicationDate` | String (ISO-8601) | Application date in format `yyyy-MM-dd'T'HH:mm:ss` |

**OUT**

| Parámetro        | Tipo   | Descripción |
|-----------------|--------|-------------|
| `productId`     | Number | Product ID |
| `brandId`       | Number | Brand ID |
| `startDate` | String (ISO-8601) | Application start date in format `yyyy-MM-dd'T'HH:mm:ss` |
| `endDate` | String (ISO-8601) | Application start date in format `yyyy-MM-dd'T'HH:mm:ss` |
| `priceList`       | Number | Price list |
| `priority`       | Number | Priority |
| `price`       | Decimal | Price |
| `currency`       | String | Currency |


## ✅ Best Practices Implemented

✔ **Hexagonal Architecture** (Layer separation with no coupling).

✔ **SOLID Principles and Clean Code**.

✔ **Jacoco Report added**.

✔ **Responses with specific HTTP status codes**.

✔ **Improvement of commit strategy with standard conventions**. Ex: 'feat: Add new Format commit'

✔ **SonarCloud Added**. SonarCloud is added for commit validation and test execution for CI implementation.



## 📜 License

This project is licensed under the MIT License. See the LICENSE file for more details.
