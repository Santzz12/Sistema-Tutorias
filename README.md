# Sistema de Tutorías - Justificación de Diseño Orientado a Objetos

Este proyecto implementa el núcleo de un sistema de reservas de tutorías en Java, aplicando las mejores prácticas de Diseño Orientado a Objetos y principios SOLID. A continuación, se detalla la justificación de las decisiones de diseño en el código:

## 1. Alta Cohesión
El diseño mantiene una alta cohesión asegurando que cada clase tenga un propósito único y bien definido. Por ejemplo, la clase `Reserva` es la única responsable de gestionar su propio ciclo de vida (cambiar su estado interno entre PENDIENTE, CONFIRMADA y CANCELADA) a través de métodos de comportamiento específicos como `confirmar()` y `cancelar()`. La lógica está distribuida correctamente entre las entidades del dominio, evitando clases concentradoras de múltiples responsabilidades.

## 2. Encapsulamiento y Ocultación de Información
Se aplicó un estricto encapsulamiento para proteger el estado interno de los objetos. Todos los atributos de las clases del dominio (`Estudiante`, `Docente`, `HorarioDisponible`, `Reserva`) poseen el modificador de acceso `private`. En lugar de exponer métodos *setters* genéricos que permitirían modificaciones inválidas desde el exterior, se diseñaron comportamientos controlados. Un claro ejemplo es la clase `HorarioDisponible`, que utiliza los métodos `bloquear()` y `liberar()` en lugar de un `setOcupado(boolean)`, protegiendo así las reglas de negocio del sistema.

## 3. Principio de Inversión de Dependencias (DIP - SOLID)
Para el sistema de notificaciones de las reservas, se aplicó el principio de Inversión de Dependencias. La clase `GestorReservas` (módulo de alto nivel) no depende de una implementación concreta para el envío de mensajes, correos o SMS (módulos de bajo nivel). En su lugar, depende de la abstracción `Notificador` (una interfaz). Esta dependencia se inyecta directamente a través de su constructor. Esto desacopla el sistema por completo, permitiendo que en el futuro se puedan agregar nuevos canales de comunicación sin necesidad de modificar el código del gestor central.