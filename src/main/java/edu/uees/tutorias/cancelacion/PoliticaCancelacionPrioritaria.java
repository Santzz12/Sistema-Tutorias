package edu.uees.tutorias.cancelacion;

import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Reserva;
import java.time.Duration;
import java.time.LocalDateTime;

public final class PoliticaCancelacionPrioritaria implements PoliticaCancelacion {
    static final long MINUTOS_MINIMOS = 30;

    @Override
    public boolean permiteCancelar(Reserva reserva, LocalDateTime momentoCancelacion) {
        boolean estadoCancelable = reserva.getEstado() == EstadoReserva.SOLICITADA
                || reserva.getEstado() == EstadoReserva.CONFIRMADA;
        long minutosDisponibles = Duration.between(
                        momentoCancelacion,
                        reserva.getHorario().getInicio())
                .toMinutes();
        return estadoCancelable && minutosDisponibles >= MINUTOS_MINIMOS;
    }

    @Override
    public String nombre() {
        return "Prioritaria (mínimo 30 minutos)";
    }
}
