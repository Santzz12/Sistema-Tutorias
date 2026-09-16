# Sistema de gestión de tutorías

Proyecto Java/Maven que continúa el diseño orientado a objetos de Ae1 y la aplicación de Factory Method y Builder realizada en Ae2.

## Línea base recuperada de Ae2

- `ReservaBuilder` construye reservas con campos obligatorios, datos opcionales y estado inicial controlado.
- `NotificacionFactory` desacopla la creación de los canales Email, SMS, WhatsApp y Push.
- `Reserva` conserva las reglas de confirmación, cancelación y finalización.

## Requisitos

- Java 17
- Maven 3.9 o superior

## Compilar, probar y ejecutar

```bash
mvn clean test
mvn exec:java
```
