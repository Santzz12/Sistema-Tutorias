package edu.uees.tutorias.observer;

import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Reserva;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CalendarioObserver implements ObservadorReserva {
    private final List<String> eventos = new ArrayList<>();

    @Override
    public void actualizar(
            Reserva reserva,
            EstadoReserva estadoAnterior,
            EstadoReserva estadoActual) {
        eventos.add("Calendario: " + reserva.getId()
                + " " + estadoAnterior + " -> " + estadoActual);
    }

    public List<String> getEventos() {
        return Collections.unmodifiableList(eventos);
    }
}
