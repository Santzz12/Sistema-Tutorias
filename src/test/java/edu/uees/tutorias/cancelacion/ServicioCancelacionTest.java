package edu.uees.tutorias.cancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.uees.tutorias.builder.ReservaBuilder;
import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioDisponible;
import edu.uees.tutorias.domain.Reserva;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioCancelacionTest {
    private static final LocalDateTime INICIO = LocalDateTime.of(2026, 9, 20, 15, 0);
    private Reserva reserva;

    @BeforeEach
    void prepararReservaConfirmada() {
        Estudiante estudiante = new Estudiante("E-1", "Erick", "e@uees.edu.ec", "Computación");
        Docente docente = new Docente("D-1", "Ana", "a@uees.edu.ec", "Software");
        HorarioDisponible horario = new HorarioDisponible(
                "H-1", docente, INICIO, INICIO.plusHours(1));
        reserva = new ReservaBuilder()
                .id("R-1")
                .estudiante(estudiante)
                .horario(horario)
                .build();
        reserva.confirmar();
    }

    @Test
    void politicaRegularAceptaConCincoHoras() {
        ServicioCancelacion servicio = new ServicioCancelacion(new PoliticaCancelacionRegular());

        ResultadoCancelacion resultado = servicio.cancelar(reserva, INICIO.minusHours(5));

        assertTrue(resultado.aceptada());
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
    }

    @Test
    void politicaRegularRechazaConUnaHora() {
        ServicioCancelacion servicio = new ServicioCancelacion(new PoliticaCancelacionRegular());

        ResultadoCancelacion resultado = servicio.cancelar(reserva, INICIO.minusHours(1));

        assertFalse(resultado.aceptada());
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }

    @Test
    void politicaPrioritariaAceptaConUnaHora() {
        ServicioCancelacion servicio = new ServicioCancelacion(new PoliticaCancelacionPrioritaria());

        ResultadoCancelacion resultado = servicio.cancelar(reserva, INICIO.minusHours(1));

        assertTrue(resultado.aceptada());
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
    }
}
