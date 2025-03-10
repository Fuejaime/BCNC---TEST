# Instrucciones

### Se deja Archivo README.md en la raiz del proyecto con las instrucciones para ejecutar el proyecto.

### Se deja Archivo HELP.md en la raiz del proyecto con las instrucciones para ejecutar el proyecto.

Para desplegar el proyecto se debe seguir los siguientes pasos: ver REAME.md


Sin embargo, he dejado algunos comments // dentro de las clases de muestran opciones de mejora necesarias para garantizar mejor operacion del proyecto.

Me gustaría tambien indicar que por tiempo marque unos puntos que deben mejorarse para garantizar la consistencia de datos esperada

### Mejoras
Ampliación de code coverage, se debe aumentar la cobertura de pruebas unitarias y de integración.

Configurar adecuadamente Mongo y Kafka

Controlar particiones e identificadores para garantizar operativa con consistencia

Configurar indices de BD y mejorar query para buscar reducir espacios.

Pruebas de carga para validar operativa.

Implementar un sistema de reintentos

Implementar un sistema de circuit breaker

Implementar un sistema de cache si es necesario

Implementar un sistema de log


Implementar un sistema de monitoreo

Implementar un sistema de alertas

Validar la inmutabilidad de los objetos (records)

Operar con proyecto multimodulo para separar capas de la aplicación con mayor seguridad

Mejorar la api para gestion de errores directo (la api retorne errore por su propia definicion)

Mejorar mappers para garantizar paso de objetos bajo responsabilidad de capa y no mezclar responsabilidades

Mejorar la gestion de excepciones para garantizar que se manejen de forma correcta

Mejorar la gestion de errores para garantizar que se manejen de forma correcta
