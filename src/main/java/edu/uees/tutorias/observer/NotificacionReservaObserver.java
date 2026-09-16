package edu.uees.tutorias.observer;

import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notificacion.NotificacionFactory;
import java.util.Objects;

public final class NotificacionReservaObserver implements ObservadorReserva {
    private final NotificacionFactory fabrica;

    public NotificacionReservaObserver(NotificacionFactory fabrica) {
        this.fabrica = Objects.requireNonNull(fabrica, "fabrica es obligatoria");
    }

    @Override
    public void actualizar(
            Reserva reserva,
            EstadoReserva estadoAnterior,
            EstadoReserva estadoActual) {
        fabrica.notificar(
                reserva.getEstudiante().getEmail(),
                "Reserva " + reserva.getId() + ": "
                        + estadoAnterior + " -> " + estadoActual);
    }
}
