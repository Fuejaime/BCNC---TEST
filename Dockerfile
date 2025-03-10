# Utilizar una imagen base de Maven para construir la aplicación con Java 17
FROM maven:3.8.5-openjdk-17 AS builder

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Construir el JAR de la aplicación
RUN mvn package -DskipTests

# Utilizar una imagen base de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR construido desde el contenedor anterior
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
