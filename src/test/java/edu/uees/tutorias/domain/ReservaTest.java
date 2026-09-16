package edu.uees.tutorias.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.uees.tutorias.builder.ReservaBuilder;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ReservaTest {
    @Test
    void confirmarYCancelarActualizaEstadoYHorario() {
        Estudiante estudiante = new Estudiante("E-1", "Erick", "e@uees.edu.ec", "Computación");
        Docente docente = new Docente("D-1", "Ana", "a@uees.edu.ec", "Software");
        HorarioDisponible horario = new HorarioDisponible(
                "H-1",
                docente,
                LocalDateTime.of(2026, 9, 20, 15, 0),
                LocalDateTime.of(2026, 9, 20, 16, 0));
        Reserva reserva = new ReservaBuilder()
                .id("R-1")
                .estudiante(estudiante)
                .horario(horario)
                .build();

        reserva.confirmar();
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertTrue(horario.isReservado());

        reserva.cancelar();
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
        assertFalse(horario.isReservado());
    }
}
