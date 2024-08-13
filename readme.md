# Kata Números romanos

### Fase 1

Desarrollar un componente que permita convertir números enteros a romanos y viceversa según el siguiente esquema:

* 1 ➔ I
* 2 ➔ II
* 3 ➔ III
* 4 ➔ IV
* 5 ➔ V
* 9 ➔ IX
* 21 ➔ XXI
* 50 ➔ L
* 100 ➔ C
* 500 ➔ D
* 1000 ➔ M

En ambos métodos de conversión, el componente debe validar si se ingresa un valor no permitido y responder con una
excepción personalizada.

**Plus Fase 1:** Aplicar TDD o al menos hacer Tests unitarios del componente probando al menos 2 border cases para cada
método de conversión.

### Fase 2

Exponer el método del componente que convierte valores numéricos arábigos a romanos en un endpoint (GET)
Exponer el método del componente que convierte valores numéricos romanos a arábigos en un endpoint (GET)

**Plus Fase 2:** Aplicar TDD (Test de integración usando la suite de Spring).

### Requerimientos/Restricciones

**Fase 1 y 2:** Usar Java 17 o superior. Maven o Gradle para la gestión de dependencias.
Para los puntos plus de cada fase, en lo relacionado a la infraestructura de tests se pueden usar las siguientes
herramientas JUnit5+Mockito o Spock y Spring Boot Testing.
**Fase 2:** Usar Spring boot 3+.

Completar y modificar este readme e incluirlo como parte del repositorio agregando detalles sobre cómo construir el
proyecto desde cero y ponerlo en ejecución.

# Proyecto de Conversión de Números Romanos

Este proyecto es una implementación de un servicio para convertir números arábigos a romanos y viceversa utilizando Java
21 y Spring Boot 3.3.2.

## Requisitos Previos

- Java 21
- Maven 3.8+.
- Spring Boot 3.3.2

## Instrucciones de Ejecución

### Clonar el Repositorio

https://github.com/Joelzlujan/romannumerals.git

### Construir el Proyecto

- mvn clean install

### Ejecutar la aplicacion

- mvn spring-boot:run

La aplicación estará disponible en http://localhost:8080.

## Endpoints

Convertir de Arábigo a Romano
GET /convert/to-roman?number={number}

Devuelve la representación romana del número arábigo especificado.

Convertir de Romano a Arábigo
GET /convert/to-arabic?roman={roman}

Devuelve la representación arábiga del número romano especificado.

### Ejecutar los Tests

- mvn test

## Estructura del Proyecto

```Estructura del Proyecto
domain: Contiene las clases de dominio como ArabicNumeral y RomanNumeral.
infrastructure.service: Implementación del servicio de conversión.
application.exception: Excepciones personalizadas para el manejo de errores en la conversión.
```

### Autor

- Joel Lujan
