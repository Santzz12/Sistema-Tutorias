package edu.uees.tutorias.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioDisponible;
import edu.uees.tutorias.domain.Reserva;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaBuilderTest {
    private Estudiante estudiante;
    private HorarioDisponible horario;

    @BeforeEach
    void prepararDatos() {
        estudiante = new Estudiante("E-1", "Erick", "erick@uees.edu.ec", "Computación");
        Docente docente = new Docente("D-1", "Ana", "ana@uees.edu.ec", "Software");
        horario = new HorarioDisponible(
                "H-1",
                docente,
                LocalDateTime.of(2026, 9, 20, 15, 0),
                LocalDateTime.of(2026, 9, 20, 16, 0));
    }

    @Test
    void creaReservaConValoresPorDefecto() {
        Reserva reserva = new ReservaBuilder()
                .id("R-1")
                .estudiante(estudiante)
                .horario(horario)
                .build();

        assertEquals(EstadoReserva.SOLICITADA, reserva.getEstado());
        assertEquals("Sin especificar", reserva.getTema());
        assertEquals("Sin observaciones", reserva.getObservaciones());
    }

    @Test
    void rechazaReservaSinHorario() {
        ReservaBuilder builder = new ReservaBuilder()
                .id("R-1")
                .estudiante(estudiante);

        assertThrows(IllegalStateException.class, builder::build);
    }
}
