# StarWars Application

This project is an application based on **Spring Boot** that exposes an API to get pricing information.

## SUMMARY

# Design Patterns and Best Practices Applied

Several design patterns and best practices are applied in the project. Below are some of them and their purpose:

## Hexagonal Architecture

- **Where**: In the project structure, separating the layers of domain, application, infrastructure, and contract.
- **Purpose**: To decouple the business logic from external dependencies, making maintenance and testing easier.

## SOLID Principles

- **Where**: In the implementation of classes and methods throughout the project.
- **Purpose**: To create code that is more understandable, flexible, and maintainable.

## Clean Code

- **Where**: In the writing of code in general.
- **Purpose**: To ensure the code is easy to read, understand, and maintain.

## Global Handler Exception

- **Where**: In the infrastructure layer, specifically in the REST controllers.
- **Purpose**: To handle exceptions in a centralized manner, improving error management and consistency in responses.

## JaCoCo

- **Where**: In the Maven configuration (pom.xml) and code coverage reports.
- **Purpose**: To measure code coverage and ensure that tests cover a significant portion of the code.

## SonarCloud

- **Where**: Integrated in GitHub Actions for code quality analysis.
- **Purpose**: To perform static code analysis and detect potential quality issues.

## Docker and Docker Compose

- **Where**: In the docker-compose.yml files and deployment configuration.
- **Purpose**: To containerize the application and facilitate its deployment and execution in different environments.

## ArgoCD and KinD

- **Where**: In the `.github/workflows/argo-cd-deploy.yml` file.
- **Purpose**: To implement continuous deployment in Kubernetes using ArgoCD and KinD (Kubernetes in Docker).

These patterns and principles are implemented to ensure that the code is of high quality, easy to maintain, and scalable.


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

**Hexagonal Architecture**: Separates the business logic (domain) from external dependencies (infrastructure, user interfaces, databases). This allows the system to be easier to maintain and test. Additionally, dependencies flow inward from the outside to the core of the application.

- **Contract**: Exposure of the REST controllers.
- **Domain**: Business logic and entities.
- **Application**: Orchestration of business logic.
- **Infrastructure**: Implementation of repositories and persistence.

**Pattern**: Hexagonal Architecture (also known as Ports and Adapters).

## ⚙️ Technologies Used

The technologies used in the project are as follows, enabling efficient development and modern infrastructure:

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
Argo CD
DockerHub

Microservices with a focus on Docker Containers and Continuous Integration/Continuous Deployment (CI/CD) tools.
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

✔ **Hexagonal Architecture** (Layer separation with no coupling). Applied to ensure layer separation and independence of business logic from infrastructure.

✔ **SOLID Principles and Clean Code**. For maintainability, and clarity of code.

✔ **Global Handler Exception**. Implementation of a centralized exception handler to manage errors consistently.

✔ **Jacoco Report added**.

✔ **Responses with specific HTTP status codes**.

✔ **Improvement of commit strategy with standard conventions**. Ex: 'feat: Add new Format commit'

✔ **SonarCloud Added**. Code is subjected to static analysis via SonarCloud to ensure it meets code quality standards.

✔ **Add DockerHub**. Docker Hub added to argo deploy.

✔ **KinD**. Add KinD to add Kubernetes to CD.

✔ **ArgoCD Deployment**. Add Argo Cd deployment with KinD on GitHub Actions.

✔ **CI/CD with GitHub Actions** Automated pipelines for continuous integration and continuous deployment with tools like Docker and ArgoCD.

## 📜 License

This project is licensed under the MIT License. See the LICENSE file for more details.
