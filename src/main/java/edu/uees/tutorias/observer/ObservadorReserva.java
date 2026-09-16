package edu.uees.tutorias.observer;

import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Reserva;

public interface ObservadorReserva {
    void actualizar(
            Reserva reserva,
            EstadoReserva estadoAnterior,
            EstadoReserva estadoActual);
}
