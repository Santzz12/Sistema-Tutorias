# Continuidad de Ae3

## Estado inicial de esta cuenta

Repositorio: https://github.com/Santzz12/Sistema-Tutorias
Base: `c84ecf8ed74543be656a7b6a3c884b0d805cf6d6`.

La base contiene cinco clases del dominio, `GestorReservas`
y `notification.Notificador`. No contenía Builder, Factory Method ni pruebas.
El archivo Maven se llamaba `Pom.xml`; en sistemas sensibles a mayúsculas
se necesitaba `mvn -f Pom.xml ...`. Se verificó la compilación de esa base
con Java 17 y `mvn -f Pom.xml clean test` antes de modificarla:
`BUILD SUCCESS`, sin pruebas disponibles en la base inicial.

## Adaptación solicitada

Se reproduce la implementación del Ae3 anterior del Sistema de gestión de
tutorías. Primero se integra su base de Builder y Factory Method, después
Strategy y Observer. Los commits previos de esta cuenta permanecen como
antecesores del incremento. Se normaliza `pom.xml` y se dejan de versionar
los archivos generados de `target/`.

El estado inicial pasa de `PENDIENTE` a `SOLICITADA`; el docente queda
asociado mediante `HorarioDisponible`. La construcción antes realizada por
`GestorReservas` queda en `ReservaBuilder`; los canales quedan en
`notificacion`, y Observer comunica las transiciones. Estas sustituciones
evitan mantener dos modelos incompatibles del mismo dominio.

## Alcance

Java 17, Maven, almacenamiento en memoria y notificaciones simuladas por
consola. Las reglas regular (120 minutos) y prioritaria (30 minutos) son
reglas del ejercicio. Los clientes cancelan mediante `ServicioCancelacion`.
No hay persistencia, envíos reales, concurrencia ni garantías de reintento
ante fallos de observadores. El estado FINALIZADA conserva ocupado el
intervalo histórico. Se conserva el nombre del estudiante del informe
original; el propietario del repositorio es la cuenta Santzz12.
