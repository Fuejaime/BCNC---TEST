# StarWars Application

Este proyecto es una aplicación basada en Spring Boot que expone una API para obtener información 
Una vez desplegado, los elementos estarán disponibles en la siguiente URL: localhost:8080/price

## Estructura del Proyecto


## Paso 1: Descomprimir y configurar Proyecto

Clona el repositorio del proyecto desde GitHub:

```bash
descomprimir zip
```

## Paso 2: Compilar con Docker, omitir si no se desea usar Docker

En la raíz del proyecto, ejecutar el siguiente comando para compilar la imagen de Docker:
```bash
docker-compose build
```

Ejecutar DockerCompose
```bash
docker-compose up
```

## Paso 3: Compilar 


```bash
mvn clean compile
```

## Paso 4: Compilar

Ejecutar la compilacion con el siguiente comando
```bash
mvn clean install
Ejecutamos StarWarsApplication.java
GET: http://localhost:8080/price
params: productId, brandId, applicationDate

```

## Paso 5: Ejecutar la Collection
Una vez puesto en marcha
```bash
Ejecutar la collection de postman

curl --location 'http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-15T21%3A00%3A00' \
--data ''
