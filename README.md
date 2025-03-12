# StarWars Application

Este proyecto es una aplicación basada en **Spring Boot** que expone una API para obtener información de precios.

## 🚀 Despliegue

Una vez desplegado, los elementos estarán disponibles en la siguiente URL:

```
http://localhost:8080/price
```

## 📂 Estructura del Proyecto

La estructura del proyecto sigue la arquitectura estándar de **Spring Boot**:

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

## ⚙️ Imagenes Sonar

### Contiene las captura de sonar local con el reporte realizado.

se adiciona sonarcloud con github Actions, donde se hace 2 iteraciones,  ejecución más ejecución de Test.



## ⚙️ Tecnologías Utilizadas
```bash

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database (en memoria para pruebas)**
- **JUnit 5 & Mockito**
- **Maven**
- **Docker & Docker Compose**
- **Lombok**
- **JaCoCo** (para cobertura de código)
- **SonarQube CLOUD** (para análisis de calidad)

## 🔧 Paso 1: Configuración del Proyecto

### 1. Clonar o Descomprimir el Proyecto

Si has descargado el proyecto en un archivo ZIP, descomprímelo. Si estás usando Git, clona el repositorio:

```bash
git clone https://github.com/Fuejaime/BCNC---TEST.git
cd starwars-application
```

## 🐳 Paso 2: Construcción con Docker (Opcional)

Si deseas ejecutar la aplicación en un contenedor Docker, sigue estos pasos:

### 1. Construir la imagen con Docker Compose

```bash
docker-compose build
```

### 2. Levantar los servicios con Docker Compose

```bash
docker-compose up
```

## 🛠️ Paso 3: Compilación y Ejecución con Maven

Si prefieres ejecutar la aplicación sin Docker, sigue estos pasos:

### 1. Compilar el código fuente

```bash
mvn clean compile
```

### 2. Construir el proyecto y generar el JAR

```bash
mvn clean install
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

O ejecuta la clase principal directamente:

```bash
java -jar target/starwars-application.jar
```

## 🌐 Paso 4: Prueba de la API

Puedes probar la API con Postman o cURL.

### 1. Prueba con Postman

Importa la colección de Postman proporcionada y ejecuta la solicitud correspondiente.

### 2. Prueba con cURL

```bash
curl --location 'http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-15T21%3A00%3A00' \
--data ''
```

## 📌 Parámetros de la API

| Parámetro        | Tipo   | Descripción |
|-----------------|--------|-------------|
| `productId`     | Número | ID del producto |
| `brandId`       | Número | ID de la marca |
| `applicationDate` | String (ISO-8601) | Fecha de aplicación en formato `yyyy-MM-dd'T'HH:mm:ss` |

## ✅ Buenas Prácticas Implementadas

✔ **Arquitectura Hexagonal** (Separación de capas y sin acoplamientos).

✔ **Principios SOLID y Clean Code**.

✔ **Adicion Jacoco Report**.

✔ **Respuestas con códigos HTTP específicos**.

✔ **Estrategia de commits con convenciones estándar**.

## 📜 Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.
