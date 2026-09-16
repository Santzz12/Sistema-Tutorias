package edu.uees.tutorias.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.uees.tutorias.builder.ReservaBuilder;
import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioDisponible;
import edu.uees.tutorias.domain.Reserva;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ReservaObserverTest {
    @Test
    void variosObservadoresRecibenCadaCambioDeEstado() {
        Reserva reserva = crearReserva();
        CalendarioObserver calendario = new CalendarioObserver();
        PanelTutoriasObserver panel = new PanelTutoriasObserver();
        reserva.agregarObservador(calendario);
        reserva.agregarObservador(panel);

        reserva.confirmar();
        reserva.cancelar();

        assertEquals(2, calendario.getEventos().size());
        assertEquals(2, panel.getEventos().size());
        assertTrue(calendario.getEventos().get(0).contains("SOLICITADA -> CONFIRMADA"));
        assertTrue(panel.getEventos().get(1).contains("CONFIRMADA -> CANCELADA"));
    }

    @Test
    void observadorEliminadoDejaDeRecibirEventos() {
        Reserva reserva = crearReserva();
        PanelTutoriasObserver panel = new PanelTutoriasObserver();
        reserva.agregarObservador(panel);
        reserva.eliminarObservador(panel);

        reserva.confirmar();

        assertTrue(panel.getEventos().isEmpty());
    }

    private Reserva crearReserva() {
        Estudiante estudiante = new Estudiante("E-1", "Erick", "e@uees.edu.ec", "Computación");
        Docente docente = new Docente("D-1", "Ana", "a@uees.edu.ec", "Software");
        LocalDateTime inicio = LocalDateTime.of(2026, 9, 20, 15, 0);
        HorarioDisponible horario = new HorarioDisponible(
                "H-1", docente, inicio, inicio.plusHours(1));
        return new ReservaBuilder()
                .id("R-1")
                .estudiante(estudiante)
                .horario(horario)
                .build();
    }
}
